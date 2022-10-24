package com.caj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.caj.model.Paciente;

public interface IPacienteService extends ICRUD<Paciente> {
	
	Page<Paciente> listarPorPagina(Pageable pageable);

}
