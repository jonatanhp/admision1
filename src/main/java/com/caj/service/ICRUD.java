package com.caj.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {
	
	T registrar(T t);
	
	T modificar(T t);
	
	List<T> listar();
	
	Optional<T> listarPorId(Integer id);
	
	void eliminar(Integer id);

}
