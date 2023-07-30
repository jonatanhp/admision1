package com.caj.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "venta")
public class Venta {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenta;

	
	@Column(name = "fecha_venta", nullable = true)
	private LocalDate fechaVenta;
	
	@Digits(integer=9, fraction=6)
	@Column(name = "precio_venta")
	private BigDecimal precioVenta;

	@Digits(integer=9, fraction=6)
	@Column(name = "precio_igv")
	private BigDecimal precioIgv;
	
	@Digits(integer=9, fraction=6)
	@Column(name = "precio_total")
	private BigDecimal precioTotal;
	
	
	@ApiModelProperty(notes = "estado de la venta 0=inactivo 1=activo")
	@Column(name = "estado", nullable=false, length = 1)
	private String estado;
	

	@OneToMany(mappedBy = "venta", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<VentaDetalle> detalle;
	
	
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;
	
	

	public Integer getIdVenta() {
		return idVenta;
	}

	

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}


	public LocalDate getFechaVenta() {
		return fechaVenta;
	}


	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}


	public BigDecimal getPrecioIgv() {
		return precioIgv;
	}


	public void setPrecioIgv(BigDecimal precioIgv) {
		this.precioIgv = precioIgv;
	}


	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}


	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Set<VentaDetalle> getDetalle() {
		return detalle;
	}


	public void setDetalle(Set<VentaDetalle> detalle) {
		this.detalle = detalle;
	}


	
	public Paciente getPaciente() {
		return paciente;
	}



	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	} 
	
	
	
	

}
