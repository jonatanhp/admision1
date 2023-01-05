package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.ITipoServicioDAO;
import com.caj.model.TipoServicio;
import com.caj.service.ITipoServicioService;

@Service
public class TipoServicioServiceImpl implements ITipoServicioService {
	
	@Autowired
	private ITipoServicioDAO dao;

	@Override
	public TipoServicio registrar(TipoServicio t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public TipoServicio modificar(TipoServicio t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<TipoServicio> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<TipoServicio> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

}
