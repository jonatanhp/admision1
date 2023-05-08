package com.caj.service;

import com.caj.dto.RegistrarCitaDTO;
import com.caj.model.Cita;

public interface ICitaService extends ICRUD<Cita> {
	
	Cita registrarCita(RegistrarCitaDTO registrarCitaDto);

}
