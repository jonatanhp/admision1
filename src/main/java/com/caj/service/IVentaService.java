package com.caj.service;

import com.caj.dto.VentaDTO;
import com.caj.model.Venta;


public interface IVentaService extends ICRUD<Venta> {
	
	Venta registrar_venta(VentaDTO ventaDTO);
	
}
