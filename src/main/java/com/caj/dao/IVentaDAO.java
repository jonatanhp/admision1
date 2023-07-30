package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Venta;

public interface IVentaDAO extends JpaRepository<Venta, Integer> {
 
}
