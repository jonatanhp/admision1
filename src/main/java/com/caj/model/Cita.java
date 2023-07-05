package com.caj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entidad cita")
@Entity
@Table(name = "cita")
public class Cita {
	//
	///
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idCita;
	
	@ManyToOne
	@JoinColumn(name = "id_persona", nullable = false)
	private Paciente paciente;
	
	@ApiModelProperty
	@Column(name = "estado", nullable = false)
	private String estado;
	
	@ApiModelProperty(notes = "hora de inicio de la cita")
	@Column(name = "hora_inicio")
	private String horaInicio;
	
	@ManyToOne
	@JoinColumn(name = "id_medico_horario", nullable = false)
	private MedicoHorario medicoHorario;

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}
	
	@JsonBackReference
	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public MedicoHorario getMedicoHorario() {
		return medicoHorario;
	}

	public void setMedicoHorario(MedicoHorario medicoHorario) {
		this.medicoHorario = medicoHorario;
	}
	
	
	

}
