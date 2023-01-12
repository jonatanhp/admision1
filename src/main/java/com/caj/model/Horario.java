package com.caj.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "horario")
public class Horario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorario;
	
	@ApiModelProperty(notes = "nombre del día, <select></select>")
	@Column(name = "nombre_dia", nullable = false, length = 10)
	private String nombreDia;
	
	@ApiModelProperty(notes = "fecha de inicio para el horario, campo obligatorio")
	@Column(name = "fecha_inicio", nullable = false)
	private LocalDate fechaInicio;
	
	@ApiModelProperty(notes = "fecha fin para el horario, campo opcional")
	@Column(name = "fecha_fin", nullable = true)
	private LocalDate fechaFin;
	
	@ApiModelProperty(notes = "hora de entrada, formato texto (10:00, 07:30, etc)")
	@Column(name = "hora_entrada", nullable = false)
	private String horaEntrada;
	
	@ApiModelProperty(notes = "hora de salida, formato texto (15:00, 18:30, etc)")
	@Column(name = "hora_salida", nullable = false)
	private String horaSalida;
	
	@ApiModelProperty(notes = "duración de la consulta, necesario para dividir el tiempo en la tabla turno")
	@Column(name = "tiempo_consulta", nullable =false, length = 2)
	private String tiempoConsulta;
	
	@ManyToOne
	@JoinColumn(name = "id_especialidad", nullable = false)
	private Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "id_consultorio", nullable = false)
	private Consultorio consultorio;

	public Integer getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(Integer idHorario) {
		this.idHorario = idHorario;
	}

	public String getNombreDia() {
		return nombreDia;
	}

	public void setNombreDia(String nombreDia) {
		this.nombreDia = nombreDia;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getTiempoConsulta() {
		return tiempoConsulta;
	}

	public void setTiempoConsulta(String tiempoConsulta) {
		this.tiempoConsulta = tiempoConsulta;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(idHorario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		return Objects.equals(idHorario, other.idHorario);
	}
	
	
	
	

}
