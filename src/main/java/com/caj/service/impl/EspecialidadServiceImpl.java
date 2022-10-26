package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IEspecialidadDAO;
import com.caj.model.Especialidad;
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
	
	
	

}
