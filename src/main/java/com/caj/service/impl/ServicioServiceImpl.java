package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IServicioDAO;
import com.caj.model.Servicio;
import com.caj.service.IServicioService;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServicioDAO dao;

	@Override
	public Servicio registrar(Servicio t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Servicio modificar(Servicio t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Servicio> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Servicio> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	
	
}
