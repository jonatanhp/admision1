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

import com.caj.exception.ModelNotFoundException;
import com.caj.model.Nivel;
import com.caj.service.INivelService;


@RestController
@RequestMapping("/niveles")
public class NivelController {
	
	@Autowired
	private INivelService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Nivel>> list(){
		List<Nivel> niveles = new ArrayList<>();
		niveles = service.listar();
		return new ResponseEntity<List<Nivel>>(niveles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Optional<Nivel>> listById(@PathVariable("id") Integer id){
		Optional<Nivel> nivel = service.listarPorId(id);
		if(!nivel.isPresent()) {
			throw new ModelNotFoundException("Id: " + id );
		}
		EntityModel<Optional<Nivel>> entityModel = EntityModel.of(nivel);
		Nivel nivel2 = nivel.get();
		Link link = WebMvcLinkBuilder.linkTo(NivelController.class).slash(nivel2.getIdNivel()).withSelfRel();
		entityModel.add(link.withRel("asdf"));
		return entityModel;
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody Nivel n){
		Nivel nivel = service.registrar(n);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(nivel.getIdNivel()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody Nivel n){
		service.modificar(n);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<Nivel> nivel = service.listarPorId(id);
		if(!nivel.isPresent()) {
			throw new ModelNotFoundException("Id : " + id + "no encontraod");
		}else {
			service.eliminar(id);
		}
	}

}
