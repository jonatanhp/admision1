package com.caj.model;

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
@Table(name = "medico_horario")
public class MedicoHorario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedicoHorario;
	
	@ApiModelProperty(notes = "estado del horario, (1=activo, 2=cesado")
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name = "id_horario", nullable = false)
	private Horario horario;

	public Integer getIdMedicoHorario() {
		return idMedicoHorario;
	}

	public void setIdMedicoHorario(Integer idMedicoHorario) {
		this.idMedicoHorario = idMedicoHorario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMedicoHorario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicoHorario other = (MedicoHorario) obj;
		return Objects.equals(idMedicoHorario, other.idMedicoHorario);
	}
	
	

}
