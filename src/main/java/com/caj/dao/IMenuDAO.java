package com.caj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caj.model.MenuChildren;
import com.caj.model.Menu;

public interface IMenuDAO extends JpaRepository<Menu, Integer> {
	
	@Query("from MenuChildren where menu.idMenu =:idMenu")
	List<MenuChildren> childrenPorMenu(@Param("idMenu") Integer idMenu);

}
