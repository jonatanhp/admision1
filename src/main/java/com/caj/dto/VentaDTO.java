package com.caj.dto;

import com.caj.model.Cuenta;
import com.caj.model.Paciente;
import com.caj.model.Venta;

public class VentaDTO {
	
	private Venta venta;
	
	private Paciente paciente;
	
	private Cuenta cuenta;

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	

}
