package com.caj.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caj.dto.RegistroCanvasDTO;
import com.caj.exception.ModelNotFoundException;
import com.caj.model.RegistroCanvasPrueba;
import com.caj.service.IRegistroCanvasPruebaService;
import com.caj.service.IServicioService;

@RestController
@RequestMapping("/canvasPrueba")
public class RegistroCanvasPruebaController {
	
	@Autowired
	private IRegistroCanvasPruebaService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegistroCanvasPrueba>> list(){
		List<RegistroCanvasPrueba> servicios = new ArrayList<>();
		servicios = service.listar();
		return new ResponseEntity<List<RegistroCanvasPrueba>>(servicios, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Optional<RegistroCanvasPrueba>> listById(@PathVariable("id") Integer id){
		Optional<RegistroCanvasPrueba> RegistroCanvasPrueba = service.listarPorId(id);
		if(!RegistroCanvasPrueba.isPresent()) {
			throw new ModelNotFoundException("Id: " + id );
		}
		EntityModel<Optional<RegistroCanvasPrueba>> entityModel = EntityModel.of(RegistroCanvasPrueba);
		RegistroCanvasPrueba nivel2 = RegistroCanvasPrueba.get();
		Link link = WebMvcLinkBuilder.linkTo(ServicioController.class).slash(nivel2.getIdRegistroCanvasPrueba()).withSelfRel();
		entityModel.add(link.withRel("asdf"));
		return entityModel;
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody RegistroCanvasPrueba n){
		RegistroCanvasPrueba RegistroCanvasPrueba = service.registrar(n);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(RegistroCanvasPrueba.getIdRegistroCanvasPrueba()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping(value = "/registro2", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register2 (@Valid @RequestBody RegistroCanvasDTO n){
		service.registrarCanvas2(n);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(RegistroCanvasPrueba.getIdRegistroCanvasPrueba()).toUri();
		return ResponseEntity.ok(null);
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody RegistroCanvasPrueba n){
		service.modificar(n);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<RegistroCanvasPrueba> RegistroCanvasPrueba = service.listarPorId(id);
		if(!RegistroCanvasPrueba.isPresent()) {
			throw new ModelNotFoundException("Id : " + id + "no encontraod");
		}else {
			service.eliminar(id);
		}
	}

}
