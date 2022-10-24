package com.caj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caj.model.Menu;
import com.caj.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {
	
	@Autowired
	private IMenuService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Menu>> listar(){
		
		List<Menu> menues = new ArrayList<>();
		menues = service.listar();
		

		
		
		/*for(Menu m: menues) {
			System.out.println("roles de menu");
			System.out.println(m.getRoles());
		}*/
		
		System.out.println(menues);
		return new ResponseEntity<List<Menu>>(menues, HttpStatus.OK);
	}
	
	
	

}
