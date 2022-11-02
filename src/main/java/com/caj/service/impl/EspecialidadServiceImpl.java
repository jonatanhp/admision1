package com.caj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IEspecialidadDAO;
import com.caj.model.Especialidad;
import com.caj.model.Medico;
import com.caj.model.Menu;
import com.caj.model.Persona;
import com.caj.service.IEspecialidadService;


@Service
public class EspecialidadServiceImpl implements IEspecialidadService {
	
	@Autowired
	private IEspecialidadDAO dao;

	@Override
	public Especialidad registrar(Especialidad t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Especialidad modificar(Especialidad t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Especialidad> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Especialidad> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public List<Persona> medicosPorEspecialidad(Integer id) {
		System.out.println("inicio metodo");
		List<Persona> medicos = new ArrayList<>();
		
		List<Integer> ids = new ArrayList<>();
		ids = dao.listarIdMedicosPorEspecialidad(id);
		System.out.println("continuacion metodo");
		System.out.println(ids);
		for(Integer i: ids) {
			System.out.println(i.getClass());
			Medico medico = new Medico();
			//medico = dao.listarMedicosPorId2(i);
			List<Object[]> o = dao.listarMedicosPorId(i);
			for (Object[] x: o ) {
				Persona m = new Persona();
				m.setId((Integer.parseInt(String.valueOf(x[0]))));
				m.setApelPat(String.valueOf(x[1]));
				m.setApelMat(String.valueOf(x[2]));
				m.setCorreo(String.valueOf(x[3]));
				m.setDireccion(String.valueOf(x[4]));
				m.setDni(String.valueOf(x[5]));
				m.setNombre(String.valueOf(x[7]));
				m.setTelefono(String.valueOf(x[9]));
				System.out.println(m.getId());
				
				
				medicos.add(m);
				
			}	
			System.out.println(o.size());
			//medicos.add(dao.listarMedicosPorId(i));
		}
		
		
		return medicos;
	}
	
	
	

}
