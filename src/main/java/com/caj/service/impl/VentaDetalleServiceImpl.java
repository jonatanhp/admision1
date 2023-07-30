package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IVentaDetalleDAO;
import com.caj.model.VentaDetalle;
import com.caj.service.IVentaDetalleService;

@Service
public class VentaDetalleServiceImpl implements IVentaDetalleService {
	
	@Autowired
	private IVentaDetalleDAO dao;

	@Override
	public VentaDetalle registrar(VentaDetalle t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public VentaDetalle modificar(VentaDetalle t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<VentaDetalle> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<VentaDetalle> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	
	
	
}
