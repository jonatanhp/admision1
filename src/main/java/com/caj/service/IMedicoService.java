package com.caj.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.caj.model.Medico;

public interface IMedicoService extends ICRUD<Medico> {
	
	Page<Medico> listarPorPagina(Pageable pageable);

}
