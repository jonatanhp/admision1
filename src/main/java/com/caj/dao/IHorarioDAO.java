package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Horario;

public interface IHorarioDAO extends JpaRepository<Horario, Integer> {

}
