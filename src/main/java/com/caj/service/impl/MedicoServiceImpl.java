package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.caj.dao.IMedicoDAO;
import com.caj.model.Medico;
import com.caj.service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService {
	
	@Autowired
	private IMedicoDAO dao;

	@Override
	public Medico registrar(Medico t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Medico modificar(Medico t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Medico> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Medico> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Page<Medico> listarPorPagina(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

}
