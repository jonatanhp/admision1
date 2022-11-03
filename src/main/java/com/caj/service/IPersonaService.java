package com.caj.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.caj.dto.ActualizarRolesDTO;
import com.caj.dto.FiltroConsultaPersona;
import com.caj.dto.RegistrarPersonaGeneral;
import com.caj.dto.RegistrarPersonaParticular;

import com.caj.model.Persona;
import com.caj.model.Usuario;

public interface IPersonaService extends ICRUD<Persona> {
	
	Page<Persona> listarPorPagina(Pageable pageable);
	
	Persona registrarGeneral(RegistrarPersonaGeneral personaGeneralDTO);
	
	Persona registrarParticular(RegistrarPersonaParticular personaParticularDTO);
	
	List<Persona> buscar(FiltroConsultaPersona filtroConsultaPersonaDTO);
	
	Page<Persona> listarMedicos(Pageable pageable);
	
	List<Object[]> search(FiltroConsultaPersona filtroConsultaPersonaDTO);
	
	
	Usuario usuarioPorPersonaId(Integer idPersona);
	
	Usuario actualizarRoles(ActualizarRolesDTO actualizarRolesDTO);
	
	Page<Persona> listPageable(Pageable pageable);
		
	

}
