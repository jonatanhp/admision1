package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entidad medico, hereda de persona")
@Entity
@Table(name = "medico")
public class Medico {
	
	@Id
	@Column(name = "id_persona")
	private Integer id;
	
	@ApiModelProperty(notes = "codigo del medico, autogenerado, por ver aún si será obligatorio")
	@Column(name = "codigo", nullable = true, length = 15)
	private String codigo;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_persona")
	private Persona persona;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	

}
