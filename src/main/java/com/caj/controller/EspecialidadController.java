package com.caj.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;

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

import com.caj.model.Especialidad;

import com.caj.service.IEspecialidadService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {
	
	
	@Autowired
	private IEspecialidadService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Especialidad>> list(){
		
		List<Especialidad> specialities = new ArrayList<>();
		
		specialities = service.listar();
		
		return new ResponseEntity<List<Especialidad>>(specialities, HttpStatus.OK);
		
		
	}
	
	@GetMapping(value = "/{id}")
	public EntityModel<Optional<Especialidad>> listById(@PathVariable("id") Integer id){
		
		Optional<Especialidad> specialty = service.listarPorId(id);
		
		if(!specialty.isPresent()) {
			
			throw new ModelNotFoundException("ID: " + id);
		
			
		}
		
		EntityModel<Optional<Especialidad>> entityModel = EntityModel.of(specialty);
		
		Especialidad specialty2 = specialty.get();
		
		Link link = WebMvcLinkBuilder.linkTo(EspecialidadController.class).slash(specialty2.getIdEspecialidad()).withSelfRel();
		
		entityModel.add(link.withRel("asdf"));
		
		return entityModel;
		
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody Especialidad spec){
		
		Especialidad specialty = new Especialidad();
		specialty = service.registrar(spec);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(specialty.getIdEspecialidad()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody Especialidad specialty){
		
		//Patient patient = new Patient();
		//patient = service.register(pat);
		service.modificar(specialty);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getIdPatient()).toUri();
		//return new ResponseEntity<Object>(HttpStatus.OK);
		return  ResponseEntity.ok("actualizado " + specialty.getIdEspecialidad());
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<Especialidad> specialty = service.listarPorId(id);
		
		if(!specialty.isPresent()) {
			
			throw new ModelNotFoundException("ID: "+ id);
			
		}else {
			
			service.eliminar(id);
			//throw new DataIntegrityViolationException("referenciado en otra tabla");
		}
		
		
		
	}
	
	

}
