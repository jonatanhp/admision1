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
import com.caj.model.Turno;
import com.caj.model.Persona;
import com.caj.service.ITurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
	
	
	@Autowired
	private ITurnoService service;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Turno>> list(){
		
		List<Turno> turnos = new ArrayList<>();
		
		turnos = service.listar();
		
		return new ResponseEntity<List<Turno>>(turnos, HttpStatus.OK);
		
		
	}
	
	
	
	
	
	@GetMapping(value = "/{id}")
	public EntityModel<Optional<Turno>> listById(@PathVariable("id") Integer id){
		
		Optional<Turno> consultorio = service.listarPorId(id);
		
		if(!consultorio.isPresent()) {
			
			throw new ModelNotFoundException("ID: " + id);
		
			
		}
		
		EntityModel<Optional<Turno>> entityModel = EntityModel.of(consultorio);
		
		Turno consultorio2 = consultorio.get();
		
		Link link = WebMvcLinkBuilder.linkTo(TurnoController.class).slash(consultorio2.getIdTurno()).withSelfRel();
		
		entityModel.add(link.withRel("asdf"));
		
		return entityModel;
		
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody Turno spec){
		
		Turno consultorio = new Turno();
		consultorio = service.registrar(spec);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(consultorio.getIdTurno()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody Turno consultorio){
		
		//Patient patient = new Patient();
		//patient = service.register(pat);
		service.modificar(consultorio);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(patient.getIdPatient()).toUri();
		//return new ResponseEntity<Object>(HttpStatus.OK);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<Turno> consultorio = service.listarPorId(id);
		
		if(!consultorio.isPresent()) {
			
			throw new ModelNotFoundException("ID: "+ id);
			
		}else {
			
			service.eliminar(id);
			//throw new DataIntegrityViolationException("referenciado en otra tabla");
		}
		
		
		
	}
	

}
