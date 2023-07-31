package com.caj.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

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
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "servicio")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idServicio;
	
	@Column(name = "nombre_servicio", nullable = false, length = 100)
	private String nombreServicio;
	
	@ApiModelProperty(notes = "estado honorarios 0 = no 1 = sí")
	@Column(name = "honorarios", nullable = false, length = 1)
	private String honorarios;
	
	@Column(name = "codigo_acp")
	private String codigoAcp;
	
	/*
	 * @Column(name = "precio_sin_igv") private double precioSinIgv;
	 */
	
	@Digits(integer=9, fraction=6)
	@Column(name = "precio_sin_igv")
	private BigDecimal precioSinIgv;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaInicio;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaFin;
	
	@Column(name = "tarifa_acp", nullable = false)
	private double tarifaAcp;
	
	@ApiModelProperty(notes = "campo para el tipo general (servicio, farmacia, etc)")
	@Column(name = "tipo", nullable = true, length = 1)
	private String tipo;
	
	@ApiModelProperty(notes = "indicador para el tipo de precio")
	@Column(name = "tipo_precio", nullable = true, length = 1)
	private String tipoPrecio;
	
	@ApiModelProperty(notes = "estado del servicio 0=inactivo 1=activo")
	@Column(name = "estado", nullable=false, length = 1)
	private String estado;
	
	@ApiModelProperty(notes = "clasificacioni (1=ex.básico, 2=ex.intermedio, 3=ex.especial")
	@Column(name = "clasificacion", nullable = true, length = 1)
	private String clasificacion;
	
	@ApiModelProperty(notes = "relación con el la tabla nivel (inmunizaciones, odontología, ecografía, rayos x, etc)")
	@ManyToOne
	@JoinColumn(name = "id_nivel", nullable = false)
	private Nivel nivel;
	
	
	
	
	@ApiModelProperty(notes = "relación con el tipo de servicio (examenes, farmacia, lacteos, hematologia, etc)")
	@ManyToOne
	@JoinColumn(name = "id_tipo_servicio", nullable = false)
	private TipoServicio tipoServicio;
	
	
	@OneToMany(mappedBy = "servicio", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<VentaDetalle> ventaDetalle;


	
	@JsonBackReference
	public List<VentaDetalle> getVentaDetalle() {
		return ventaDetalle;
	}




	public void setVentaDetalle(List<VentaDetalle> ventaDetalle) {
		this.ventaDetalle = ventaDetalle;
	}




	public Integer getIdServicio() {
		return idServicio;
	}




	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}




	public String getNombreServicio() {
		return nombreServicio;
	}




	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}




	public String getHonorarios() {
		return honorarios;
	}




	public void setHonorarios(String honorarios) {
		this.honorarios = honorarios;
	}




	public String getCodigoAcp() {
		return codigoAcp;
	}




	public void setCodigoAcp(String codigoAcp) {
		this.codigoAcp = codigoAcp;
	}




	public BigDecimal getPrecioSinIgv() {
		return precioSinIgv;
	}




	public void setPrecioSinIgv(BigDecimal precioSinIgv) {
		this.precioSinIgv = precioSinIgv;
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




	public double getTarifaAcp() {
		return tarifaAcp;
	}




	public void setTarifaAcp(double tarifaAcp) {
		this.tarifaAcp = tarifaAcp;
	}




	public String getTipo() {
		return tipo;
	}




	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public String getTipoPrecio() {
		return tipoPrecio;
	}




	public void setTipoPrecio(String tipoPrecio) {
		this.tipoPrecio = tipoPrecio;
	}




	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}




	public String getClasificacion() {
		return clasificacion;
	}




	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}




	public Nivel getNivel() {
		return nivel;
	}




	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}




	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}




	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	
	
	
	

}
