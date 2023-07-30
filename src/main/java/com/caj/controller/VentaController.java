package com.caj.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caj.dto.VentaDTO;
import com.caj.exception.ModelNotFoundException;
import com.caj.model.Venta;
import com.caj.service.IVentaService;


@RestController
@RequestMapping("/ventass")
public class VentaController {
	
	@Autowired
	private IVentaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Venta>> listar(){
		List<Venta> ventas = new ArrayList<>();
		ventas = service.listar();
		
		return new ResponseEntity<List<Venta>>(ventas, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public EntityModel<Optional<Venta>> listarPorId(@PathVariable("id") Integer id){
		Optional<Venta> venta = service.listarPorId(id);
		if(!venta.isPresent()) {
			throw new ModelNotFoundException("no existe Venta con id :  " + id);
		}
		
		EntityModel<Optional<Venta>> entityModel = EntityModel.of(venta);
		Venta venta2 = venta.get();
		Link link = WebMvcLinkBuilder.linkTo(VentaController.class).slash(venta2).withSelfRel();
		entityModel.add(link.withRel("Venta recuperado"));
		
		
		return entityModel;
	}
	
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Venta Venta){
		Venta IVenta = new Venta();
		IVenta = service.registrar(Venta);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(IVenta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PostMapping(value = "/reg_venta",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody VentaDTO ventaDTO){
		Venta venta = new Venta();
		venta = service.registrar_venta(ventaDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta.getIdVenta()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar (@Valid @RequestBody Venta Venta){
		service.modificar(Venta);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Venta> venta = service.listarPorId(id);
		if(!venta.isPresent()) {
			throw new ModelNotFoundException("no existe Venta con id:  " + id);
		}else {
			service.eliminar(id);
		}
		
		
	}

}
