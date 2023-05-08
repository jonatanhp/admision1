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

import com.caj.dto.RegistrarCitaDTO;
import com.caj.exception.ModelNotFoundException;
import com.caj.model.Cita;
import com.caj.service.ICitaService;


@RestController
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	private ICitaService citaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cita>> list(){
		List<Cita> citas = new ArrayList<>();
		citas = citaService.listar();
		
		return new ResponseEntity<List<Cita>>(citas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Optional<Cita>> listById(@PathVariable("id") Integer id){
		Optional<Cita> cita = citaService.listarPorId(id);
		if(!cita.isPresent()) {
			throw new ModelNotFoundException("Id: " + id );
		}
		EntityModel<Optional<Cita>> entityModel = EntityModel.of(cita);
		Cita cita2 = cita.get();
		Link link = WebMvcLinkBuilder.linkTo(CitaController.class).slash(cita2.getIdCita()).withSelfRel();
		entityModel.add(link.withRel("asdf"));
		return entityModel;
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody Cita n){
		Cita cita = citaService.registrar(n);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cita.getIdCita()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody RegistrarCitaDTO citaDTO){
		Cita cita = new Cita();
		cita = citaService.registrarCita(citaDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cita.getIdCita()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody Cita n){
		citaService.modificar(n);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<Cita> cita = citaService.listarPorId(id);
		if(!cita.isPresent()) {
			throw new ModelNotFoundException("Id : " + id + "no encontraod");
		}else {
			citaService.eliminar(id);
		}
	}

}
