package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.INivelDAO;
import com.caj.model.Nivel;
import com.caj.service.INivelService;

@Service
public class NivelServiceImpl implements INivelService {
	
	@Autowired
	private INivelDAO dao;

	@Override
	public Nivel registrar(Nivel t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Nivel modificar(Nivel t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Nivel> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Nivel> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
