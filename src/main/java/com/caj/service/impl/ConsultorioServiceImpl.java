package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IConsultorioDAO;
import com.caj.dao.IEspecialidadDAO;
import com.caj.model.Consultorio;
import com.caj.service.IConsultorioService;

@Service
public class ConsultorioServiceImpl implements IConsultorioService {
	
	@Autowired
	private IConsultorioDAO dao;

	@Override
	public Consultorio registrar(Consultorio t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Consultorio modificar(Consultorio t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Consultorio> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Consultorio> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
