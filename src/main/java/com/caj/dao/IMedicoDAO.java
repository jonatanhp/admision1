package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Medico;

public interface IMedicoDAO extends JpaRepository<Medico, Integer> {
	
	

}
