package com.caj.dto;

import com.caj.model.Cita;
import com.caj.model.MedicoHorario;
import com.caj.model.Paciente;

public class RegistrarCitaDTO {
	
	private MedicoHorario medicoHorario;
	
	
	private Paciente paciente;
	
	
	private Cita cita;


	public MedicoHorario getMedicoHorario() {
		return medicoHorario;
	}


	public void setMedicoHorario(MedicoHorario medicoHorario) {
		this.medicoHorario = medicoHorario;
	}


	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public Cita getCita() {
		return cita;
	}


	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	

}
