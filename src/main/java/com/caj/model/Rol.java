package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Descripción de la entidad rol, por ahora (admin, user)")
@Entity
@Table(name = "rol")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRol;
	
	@ApiModelProperty(notes = "nombre del rol, máximo 50 caracteres, no permite nulos")
	@Column(name = "nombre_rol" , nullable = false, length = 50)
	private String nombreRol;
	
	@ApiModelProperty(notes = "descripción del rol, permite nulos")
	@Column(name ="desc_rol" , nullable = false, length = 1000)
	private String descRol;
	
	@ApiModelProperty(notes = "campo para marcar el estado (activo o inactivo) del rol, no permite nulos y por defecto es 1 (activo)")
	@Column(name = "estado", nullable = false, length = 2 )
	private String estado;

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public String getDescRol() {
		return descRol;
	}

	public void setDescRol(String descRol) {
		this.descRol = descRol;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	

}
