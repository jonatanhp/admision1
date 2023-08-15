package com.caj.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class RegistroCanvasPrueba {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistroCanvasPrueba;
	
	@Column(nullable = true)
	private String superA;
	
	@Column(nullable = true)
	private String superB;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	private String trazo1;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	private String trazo2;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	private String trazo3;
	
	@Column(columnDefinition = "TEXT",nullable = true)
	private String trazo4;
	
	@Column(nullable = true)
	private String lineas;
	
	@Column(nullable = true)
	private String listaFor;
	
	@Column(nullable = true)
	private String margenes;
	
	@Column(nullable = true)
	private String zigzag;
	
	@Column(nullable = true)
	private String rayas;
	
	@Column(nullable = true)
	private String formas;
	
	@Column(nullable = true)
	private String mPosi;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDateTime fechaRegistro;
	
	
	@ManyToOne
	@JoinColumn(name = "id_cita", nullable = false)
	private Cita cita;


	public Integer getIdRegistroCanvasPrueba() {
		return idRegistroCanvasPrueba;
	}


	public void setIdRegistroCanvasPrueba(Integer idRegistroCanvasPrueba) {
		this.idRegistroCanvasPrueba = idRegistroCanvasPrueba;
	}


	public String getSuperA() {
		return superA;
	}


	public void setSuperA(String superA) {
		this.superA = superA;
	}


	public String getSuperB() {
		return superB;
	}


	public void setSuperB(String superB) {
		this.superB = superB;
	}


	public String getTrazo1() {
		return trazo1;
	}


	public void setTrazo1(String trazo1) {
		this.trazo1 = trazo1;
	}


	public String getTrazo2() {
		return trazo2;
	}


	public void setTrazo2(String trazo2) {
		this.trazo2 = trazo2;
	}


	public String getTrazo3() {
		return trazo3;
	}


	public void setTrazo3(String trazo3) {
		this.trazo3 = trazo3;
	}


	public String getTrazo4() {
		return trazo4;
	}


	public void setTrazo4(String trazo4) {
		this.trazo4 = trazo4;
	}


	public String getLineas() {
		return lineas;
	}


	public void setLineas(String lineas) {
		this.lineas = lineas;
	}


	public String getListaFor() {
		return listaFor;
	}


	public void setListaFor(String listaFor) {
		this.listaFor = listaFor;
	}


	public String getMargenes() {
		return margenes;
	}


	public void setMargenes(String margenes) {
		this.margenes = margenes;
	}


	public String getZigzag() {
		return zigzag;
	}


	public void setZigzag(String zigzag) {
		this.zigzag = zigzag;
	}


	public String getRayas() {
		return rayas;
	}


	public void setRayas(String rayas) {
		this.rayas = rayas;
	}


	public String getFormas() {
		return formas;
	}


	public void setFormas(String formas) {
		this.formas = formas;
	}


	public String getmPosi() {
		return mPosi;
	}


	public void setmPosi(String mPosi) {
		this.mPosi = mPosi;
	}


	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	public Cita getCita() {
		return cita;
	}


	public void setCita(Cita cita) {
		this.cita = cita;
	}
	
	
	
	
	
	

}
