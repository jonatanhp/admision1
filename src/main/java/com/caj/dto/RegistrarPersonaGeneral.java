package com.caj.dto;

import com.caj.model.Paciente;
import com.caj.model.Persona;
import com.caj.model.Usuario;

public class RegistrarPersonaGeneral {
	
	private Usuario usuario;
	
	private Persona persona;
	
	private Paciente paciente;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	

}
