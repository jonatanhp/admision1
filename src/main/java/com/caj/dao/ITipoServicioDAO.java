package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.TipoServicio;

public interface ITipoServicioDAO extends JpaRepository<TipoServicio, Integer> {

}
