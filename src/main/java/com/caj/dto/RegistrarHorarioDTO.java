package com.caj.dto;

import com.caj.model.Horario;
import com.caj.model.Medico;
import com.caj.model.MedicoHorario;

public class RegistrarHorarioDTO {
	
	private Medico medico;
	
	private Horario horario;
	
	private MedicoHorario medicoHorario;

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public MedicoHorario getMedicoHorario() {
		return medicoHorario;
	}

	public void setMedicoHorario(MedicoHorario medicoHorario) {
		this.medicoHorario = medicoHorario;
	}
	
	

}
