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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.caj.dto.ActualizarRolesDTO;
import com.caj.dto.FiltroConsultaPersona;
import com.caj.dto.RegistrarPersonaGeneral;
import com.caj.dto.RegistrarPersonaParticular;
import com.caj.exception.ModelNotFoundException;
import com.caj.model.Persona;
import com.caj.model.Usuario;
import com.caj.service.IPersonaService;
import com.caj.service.IUsuarioService;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	@Autowired
	private IUsuarioService uservice;
	
	//@@PreAuthorize("@restAuthService.hasAccess('listar')")
	//@PreAuthorize("hasAuthority('COORDINADOR') or hasAuthority('ADMIN')")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> personas = new ArrayList<>();
		personas = service.listar();
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public EntityModel<Optional<Persona>> listarPorId(@PathVariable("id") Integer id){
		Optional<Persona> persona;
		persona = service.listarPorId(id);
		
		if(!persona.isPresent()) {
			throw new ModelNotFoundException("no existe persona con id :  " +id);
		}
		
		EntityModel<Optional<Persona>> entityModel = EntityModel.of(persona);
		Link link = WebMvcLinkBuilder.linkTo(PersonaController.class).slash(persona.get().getId()).withSelfRel();
		entityModel.add(link.withRel("persona encontrada" + persona.get().getNombre()));
		return entityModel;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody RegistrarPersonaGeneral personaGeneralDTO){
		Persona persona = new Persona();
		persona = service.registrarGeneral(personaGeneralDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(value = "/regmedico", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrarMedico(@Valid  @RequestBody RegistrarPersonaParticular personaParticularDTO){
		Persona persona = new Persona();
		persona = service.registrarParticular(personaParticularDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(persona.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PutMapping(value = "/rol", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> actualizarRoles(@Valid @RequestBody ActualizarRolesDTO actualizarRolesDTO){
		Usuario usuario = new Usuario();
		usuario = service.actualizarRoles(actualizarRolesDTO);
		uservice.modificar(usuario);
		
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping(value = "/buscar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> buscar(@RequestBody FiltroConsultaPersona filtroDTO){
		List<Persona> personas = new ArrayList<>();
		
		personas = service.buscar(filtroDTO);
		System.out.println("inicio buscar persona");
		System.out.println(personas);
		System.out.println("fin buscar persona");
		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	
	

}
