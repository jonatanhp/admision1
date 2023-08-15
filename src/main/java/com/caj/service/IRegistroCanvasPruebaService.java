package com.caj.service;

import com.caj.dto.RegistroCanvasDTO;
import com.caj.model.RegistroCanvasPrueba;

public interface IRegistroCanvasPruebaService extends ICRUD<RegistroCanvasPrueba> {
	
	void registrarCanvas(RegistroCanvasDTO regis);

	void registrarCanvas2(RegistroCanvasDTO regis);

}
