package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.VentaDetalle;

public interface IVentaDetalleDAO extends JpaRepository<VentaDetalle, Integer> {

}
