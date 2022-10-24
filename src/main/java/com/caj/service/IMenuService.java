package com.caj.service;

import java.util.List;

import com.caj.model.MenuChildren;
import com.caj.model.Menu;

public interface IMenuService extends ICRUD<Menu> {
	
	List<Menu> listarMenuPorUsuario(String nombre);
	
	
	List<MenuChildren> children(Integer idMenu);

}
