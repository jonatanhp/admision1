package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caj.model.Paciente;

public interface IPacienteDAO extends JpaRepository<Paciente, Integer> {

}
