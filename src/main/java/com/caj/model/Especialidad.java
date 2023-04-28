package com.caj.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "especialidad description")
@Entity
@Table(name = "especialidad")
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	
	@ApiModelProperty(notes = "debe ingresar el nombre de la especialidad")
	@Size(min= 3, message = "minimo 3 caracteres")
	@Column(name = "name", nullable=false, length=200 )
	private String name;
	
	
	
	@CreatedDate
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaCreacion;
	
	

	public Especialidad() {};
	
	public Especialidad(Integer idEspecialidad, @Size(min = 3, message = "minimo 3 caracteres") String name) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.name = name;
	}

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
	
	

}
