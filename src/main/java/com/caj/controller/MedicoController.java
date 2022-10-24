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

import com.caj.exception.ModelNotFoundException;
import com.caj.model.Medico;
import com.caj.service.IMedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private IMedicoService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Medico>> listar(){
		List<Medico> medicos = new ArrayList<>();
		medicos = service.listar();
		
		return new ResponseEntity<List<Medico>>(medicos, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public EntityModel<Optional<Medico>> listarPorId(@PathVariable("id") Integer id){
		Optional<Medico> medico = service.listarPorId(id);
		if(!medico.isPresent()) {
			throw new ModelNotFoundException("no existe medico con id :  " + id);
		}
		
		EntityModel<Optional<Medico>> entityModel = EntityModel.of(medico);
		Medico medico2 = medico.get();
		Link link = WebMvcLinkBuilder.linkTo(MedicoController.class).slash(medico2).withSelfRel();
		entityModel.add(link.withRel("medico recuperado"));
		
		
		return entityModel;
	}
	
	public ResponseEntity<Page<Medico>> listarPorPagina(Pageable pageable){
		
		Page<Medico> pagina;
		pagina = service.listarPorPagina(pageable);
		return new ResponseEntity<Page<Medico>>(pagina, HttpStatus.OK);
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody Medico medico){
		Medico Imedico = new Medico();
		Imedico = service.registrar(medico);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Imedico.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modificar (@Valid @RequestBody Medico medico){
		service.modificar(medico);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void eliminar(@PathVariable Integer id) {
		Optional<Medico> medico = service.listarPorId(id);
		if(!medico.isPresent()) {
			throw new ModelNotFoundException("no existe medico con id:  " + id);
		}else {
			service.eliminar(id);
		}
		
		
	}

}
