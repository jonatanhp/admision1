package com.caj.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "entidad paciente, hereda de persona")
@Entity
@Table(name = "paciente")
public class Paciente {
	
	@Id
	@Column(name = "id_persona")
	private Integer id;
	
	@ApiModelProperty(notes = "codigo del paciente, autogenerado, por ver aún si será obligatorio")
	@Column(name = "codigo", nullable = true, length = 15)
	private String codigo;
	
	
	@OneToOne
	@MapsId
	@JoinColumn(name = "id_persona")
	private Persona persona;
	
	
	@OneToMany(mappedBy = "paciente", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Cita> citas;


	public List<Cita> getCitas() {
		return citas;
	}


	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}


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

	@JsonBackReference
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}
