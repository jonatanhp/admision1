package com.caj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.IMenuDAO;
import com.caj.model.Menu;
import com.caj.model.MenuChildren;
import com.caj.service.IMenuService;

@Service
public class MenuServiceImpl implements IMenuService {
	
	@Autowired
	private IMenuDAO dao;

	@Override
	public Menu registrar(Menu t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Menu modificar(Menu t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Menu> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Menu> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);;
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		// TODO Auto-generated method stub
		
		List<Menu> listaDeMenus = new ArrayList<>();
		
		
		return null;
	}

	@Override
	public List<MenuChildren> children(Integer idMenu) {
		// TODO Auto-generated method stub
		List<MenuChildren> children = new ArrayList<>();
		children = dao.childrenPorMenu(idMenu);
		return children;
	}

}
