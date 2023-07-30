package com.caj.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "venta_detalle")
public class VentaDetalle {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVentaDetalle;
	
	
	@Digits(integer=9, fraction=6)
	@Column(name = "precio_venta")
	private BigDecimal precioVenta;

	@Digits(integer=9, fraction=6)
	@Column(name = "precio_igv")
	private BigDecimal precioIgv;
	
	@Digits(integer=9, fraction=6)
	@Column(name = "precio_total")
	private BigDecimal precioTotal;
	
	@Column(name = "fecha_venta_detalle", nullable = true)
	private LocalDate fechaVentaDetalle;
	
	@ApiModelProperty(notes = "estado de la venta 0=inactivo 1=activo")
	@Column(name = "estado", nullable=false, length = 1)
	private String estado;
	
	
	
	@ManyToOne
	@JoinColumn(name = "id_venta", nullable = false)
	private Venta venta;
	
	
	@ManyToOne
	@JoinColumn(name = "id_servicio", nullable = false)
	private Servicio servicio;
	
	@Column(name = "cantidad", nullable=false, length=200, columnDefinition = "integer default 1" )
	private int cantidad;

	public Integer getIdVentaDetalle() {
		return idVentaDetalle;
	}

	public void setIdVentaDetalle(Integer idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
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

	public LocalDate getFechaVentaDetalle() {
		return fechaVentaDetalle;
	}

	public void setFechaVentaDetalle(LocalDate fechaVentaDetalle) {
		this.fechaVentaDetalle = fechaVentaDetalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@JsonBackReference
	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	

}
