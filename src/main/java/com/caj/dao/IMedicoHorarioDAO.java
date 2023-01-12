package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.MedicoHorario;

public interface IMedicoHorarioDAO extends JpaRepository<MedicoHorario, Integer> {

}
