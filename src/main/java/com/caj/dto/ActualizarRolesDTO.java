package com.caj.dto;

import java.util.List;

import com.caj.model.Persona;
import com.caj.model.Rol;
import com.caj.model.Usuario;

public class ActualizarRolesDTO {
	
	private Usuario usuario;
	
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	private List<Rol> roles;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
	
	
	
	

}
