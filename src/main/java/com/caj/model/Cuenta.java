package com.caj.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idcuenta;

	
	@Column(name = "fecha_inicio", nullable = true)
	private LocalDate fechaInicio;
	
	@Column(name = "fecha_fin", nullable = true)
	private LocalDate fechaFin;
	
	@Column(name = "fecha_cierre", nullable = true)
	private LocalDate fechaCierre;
	
	@Column(name = "nro_cta", nullable = false)
	private String nroCta;
	
	@ApiModelProperty(notes = "1 = activo ; 2 = inactivo")
	@Column(name = "estado", nullable = false)
	private String estado;
	
	
	 
	@Digits(integer=9, fraction=6)
	@Column(name = "costo_acumulado")
	private BigDecimal costoAcumulado;
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;
	
	@OneToMany(mappedBy = "cuenta", cascade = { CascadeType.ALL,
			 }, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<Venta> ventas;

	public Integer getIdcuenta() {
		return idcuenta;
	}

	public void setIdcuenta(Integer idcuenta) {
		this.idcuenta = idcuenta;
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

	public LocalDate getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public String getNroCta() {
		return nroCta;
	}

	public void setNroCta(String nroCta) {
		this.nroCta = nroCta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public BigDecimal getCostoAcumulado() {
		return costoAcumulado;
	}

	public void setCostoAcumulado(BigDecimal costoAcumulado) {
		this.costoAcumulado = costoAcumulado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Set<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}
	
	
	

	


}
