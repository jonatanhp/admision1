package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "nivel")
public class Nivel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNivel;
	
	@ApiModelProperty(notes = "nombre del nivel")
	@Column(name = "nombre_nivel", nullable=false, length = 100)
	private String nombreNivel;

	public Integer getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Integer idNivel) {
		this.idNivel = idNivel;
	}

	public String getNombreNivel() {
		return nombreNivel;
	}

	public void setNombreNivel(String nombreNivel) {
		this.nombreNivel = nombreNivel;
	}
	
	

}
