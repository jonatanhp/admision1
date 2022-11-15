package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Consultorio;

public interface IConsultorioDAO extends JpaRepository<Consultorio, Integer> {
	
}
