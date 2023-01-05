package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Servicio;

public interface IServicioDAO extends JpaRepository<Servicio, Integer>  {

}
