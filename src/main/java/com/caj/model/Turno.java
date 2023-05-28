package com.caj.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entidad de turno")
@Entity
@Table(name = "turno")
public class Turno {
	
	@ApiModelProperty(notes = "id del turno")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTurno;
	
	@ApiModelProperty(notes = "dia de la semana del turno, a ver si se ingresa o se obtiene de la base de datos")
	@Column(name ="dia_semana", nullable = false, length = 20)
	private String dia_semana;
	
	@ApiModelProperty(notes = "fecha de inicio de la programación del turno")
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDateTime fechaInicio;
	
	@ApiModelProperty(notes ="fin de la programación del turno")
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "fecha_fin", nullable = true)
	private LocalDateTime fechaFin;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_medico_horario", nullable = false)
	private MedicoHorario medicoHorario;

	
	



	@JsonBackReference
	public MedicoHorario getMedicoHorario() {
		return medicoHorario;
	}





	public void setMedicoHorario(MedicoHorario medicoHorario) {
		this.medicoHorario = medicoHorario;
	}





	public Integer getIdTurno() {
		return idTurno;
	}





	public void setIdTurno(Integer idTurno) {
		this.idTurno = idTurno;
	}





	public String getDia_semana() {
		return dia_semana;
	}





	public void setDia_semana(String dia_semana) {
		this.dia_semana = dia_semana;
	}





	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}





	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}





	public LocalDateTime getFechaFin() {
		return fechaFin;
	}





	public void setFechaFin(LocalDateTime fechaFin) {
		this.fechaFin = fechaFin;
	}





	
	
	
	

}
