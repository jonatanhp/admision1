package com.caj.model;

import java.util.List;
import java.util.Objects;
import java.util.Set;

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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




@ApiModel(description = "entidad paciente, hereda de persona")
@Entity
@Table(name = "paciente")
/*
 * @JsonIdentityInfo( generator = ObjectIdGenerators.PropertyGenerator.class,
 * property = "id")
 */
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
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = false)
	private Set<Cita> citas;
	
	@OneToMany(mappedBy = "paciente", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = false)
	private Set<Venta> ventas;
	
	@OneToMany(mappedBy = "paciente", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = false)
	private Set<Cuenta> cuentas;
	

	@JsonManagedReference(value = "paciente-citas")
	public Set<Cita> getCitas() {
		return citas;
	}


	public void setCitas(Set<Cita> citas) {
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

	@JsonManagedReference(value = "persona-paciente")
	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	
	
	
	
	public Set<Cuenta> getCuentas() {
		return cuentas;
	}


	public void setCuentas(Set<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}


	//@JsonManagedReference(value = "paciente-ventas")
	@JsonIgnore
	public Set<Venta> getVentas() {
		return ventas;
	}


	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
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
