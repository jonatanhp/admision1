package com.caj.controller;


import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caj.exception.ModelNotFoundException;
import com.caj.model.Paciente;
import com.caj.service.IPacienteService;

@RestController
@RequestMapping("/estudiantes")
public class PacienteController {
	
	@Autowired
	private IPacienteService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Paciente>> listar(){
		List<Paciente> estudiantes = new ArrayList<>();
		estudiantes = service.listar();
		return new ResponseEntity<List<Paciente>>(estudiantes, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public EntityModel<Optional<Paciente>> listarPorId(@PathVariable("id") Integer id){
		Optional<Paciente> estudiante = service.listarPorId(id);
		if(!estudiante.isPresent()) {
			throw new ModelNotFoundException("no existe estudiante con id :  " + id);
		}
		EntityModel<Optional<Paciente>> entityModel = EntityModel.of(estudiante);
		
		Link link = WebMvcLinkBuilder.linkTo(PacienteController.class).slash(estudiante.get().getId()).withSelfRel();
		
		entityModel.add(link.withRel("estudiante recuperado"));
		
		return entityModel;
		
	}
	
	public ResponseEntity<Page<Paciente>> listarPorPagina(Pageable pageable){
		Page<Paciente> pagina;
		pagina = service.listarPorPagina(pageable);
		return new ResponseEntity<Page<Paciente>>(pagina, HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Paciente estudiante){
		Paciente Iestudiante = new Paciente();
		
		Iestudiante = service.registrar(estudiante);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Iestudiante.getId()).toUri();
		
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar(@Valid @RequestBody Paciente estudiante){
		service.modificar(estudiante);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	public void eliminar(@PathVariable Integer id) {
		Optional<Paciente> estudiante = service.listarPorId(id);
		if(!estudiante.isPresent()){
			throw new ModelNotFoundException("no existe estudiante con id :  " + id);
		}else {
			service.eliminar(id);
		}
	}

}
