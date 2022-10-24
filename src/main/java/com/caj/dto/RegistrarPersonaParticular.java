package com.caj.dto;

import com.caj.model.Medico;
import com.caj.model.Persona;
import com.caj.model.Usuario;

public class RegistrarPersonaParticular {
	
	private Usuario usuario;
	
	private Persona persona;
	
	private Medico medico;

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

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	

}
