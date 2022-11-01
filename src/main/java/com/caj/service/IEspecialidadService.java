package com.caj.service;

import java.util.List;

import com.caj.model.Especialidad;
import com.caj.model.Persona;


public interface IEspecialidadService extends ICRUD<Especialidad> {
	
	
	List<Persona> medicosPorEspecialidad(Integer id);

}
