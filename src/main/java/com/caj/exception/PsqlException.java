package com.caj.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class PsqlException extends RuntimeException {
	
	public PsqlException(String mensaje) {
		super(mensaje);
	}

}
