package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caj.dao.IVentaDAO;
import com.caj.dto.VentaDTO;
import com.caj.model.Venta;
import com.caj.service.IVentaService;


@Service
public class VentaServiceImpl implements IVentaService {
	@Autowired
	private IVentaDAO dao;

	@Override
	public Venta registrar(Venta t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}
	
	@Transactional
	@Override
	public Venta registrar_venta(VentaDTO ventaDTO) {
		ventaDTO.getVenta().getDetalle().forEach(x -> x.setVenta(ventaDTO.getVenta()));
		dao.save(ventaDTO.getVenta());
		//ventaDTO.getLstExamen().forEach(e -> ceDAO.registrar(consultaDTO.getConsulta().getIdConsulta(), e.getIdExamen()));
		
		return ventaDTO.getVenta();
	}

	@Override
	public Venta modificar(Venta t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Venta> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Venta> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	
	

}
