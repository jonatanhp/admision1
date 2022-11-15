package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.ITurnoDAO;
import com.caj.model.Turno;
import com.caj.service.ITurnoService;

@Service
public class TurnoServiceImpl implements ITurnoService {
	
	@Autowired
	private ITurnoDAO dao;

	@Override
	public Turno registrar(Turno t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Turno modificar(Turno t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Turno> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Turno> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
