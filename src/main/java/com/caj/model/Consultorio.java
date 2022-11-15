package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entidad consultorio")
@Entity
@Table(name = "consultorio")
public class Consultorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsultorio;
	
	@ApiModelProperty(notes = "nombre consultorio")
	@Column(name = "nombre_consultorio", nullable = false, length = 100)
	private String nombreConsultorio;

	public Integer getIdConsultorio() {
		return idConsultorio;
	}

	public void setIdConsultorio(Integer idConsultorio) {
		this.idConsultorio = idConsultorio;
	}

	public String getNombreConsultorio() {
		return nombreConsultorio;
	}

	public void setNombreConsultorio(String nombreConsultorio) {
		this.nombreConsultorio = nombreConsultorio;
	}
	
	
	
	

}
