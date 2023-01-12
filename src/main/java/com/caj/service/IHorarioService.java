package com.caj.service;

import com.caj.dto.RegistrarHorarioDTO;
import com.caj.model.Horario;

public interface IHorarioService extends ICRUD<Horario> {

		
	Horario registrarHorario(RegistrarHorarioDTO registrarHorarioDto); 
}
