package com.caj.dto;

import com.caj.model.Consultorio;
import com.caj.model.Especialidad;
import com.caj.model.Horario;
import com.caj.model.Medico;
import com.caj.model.MedicoHorario;

public class RegistrarHorarioDTO {
	
	private Medico medico;
	
	private Horario horario;
	
	private Consultorio consultorio;
	
	private Especialidad especialidad;
	
	
	
	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

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
