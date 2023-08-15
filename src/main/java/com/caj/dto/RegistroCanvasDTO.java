package com.caj.dto;

import com.caj.model.RegistroCanvasPrueba;

public class RegistroCanvasDTO {
	
	RegistroCanvasPrueba regis;
	
	String id_cita;
	
	public String getId_cita() {
		return id_cita;
	}

	public void setId_cita(String id_cita) {
		this.id_cita = id_cita;
	}

	String campo;
	
	String valor;

	public RegistroCanvasPrueba getRegis() {
		return regis;
	}

	public void setRegis(RegistroCanvasPrueba regis) {
		this.regis = regis;
	}

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	

}
