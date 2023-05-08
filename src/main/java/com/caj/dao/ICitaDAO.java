package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Cita;

public interface ICitaDAO extends JpaRepository<Cita, Integer> {

}
