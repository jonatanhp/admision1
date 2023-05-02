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

import com.caj.dto.RegistrarHorarioDTO;
import com.caj.dto.RegistrarPersonaGeneral;
import com.caj.exception.ModelNotFoundException;
import com.caj.model.Horario;
import com.caj.model.Persona;
import com.caj.service.IHorarioService;


@RestController
@RequestMapping("/horarios")
public class HorarioController {
	
	@Autowired
	private IHorarioService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Horario>> list(){
		List<Horario> horarios = new ArrayList<>();
		horarios = service.listar();
		for(Horario h : horarios) {
			System.out.println("horaa : "  + h.getFechaInicio());
		}
		return new ResponseEntity<List<Horario>>(horarios, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Optional<Horario>> listById(@PathVariable("id") Integer id){
		Optional<Horario> horario = service.listarPorId(id);
		if(!horario.isPresent()) {
			throw new ModelNotFoundException("Id: " + id );
		}
		EntityModel<Optional<Horario>> entityModel = EntityModel.of(horario);
		Horario horario2 = horario.get();
		Link link = WebMvcLinkBuilder.linkTo(HorarioController.class).slash(horario2.getIdHorario()).withSelfRel();
		entityModel.add(link.withRel("asdf"));
		return entityModel;
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody Horario n){
		Horario horario = service.registrar(n);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(horario.getIdHorario()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PostMapping(value = "/registrar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registrar(@Valid @RequestBody RegistrarHorarioDTO horarioDTO){
		Horario horario = new Horario();
		horario = service.registrarHorario(horarioDTO);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(horario.getIdHorario()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody Horario n){
		service.modificar(n);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<Horario> horario = service.listarPorId(id);
		if(!horario.isPresent()) {
			throw new ModelNotFoundException("Id : " + id + "no encontraod");
		}else {
			service.eliminar(id);
		}
	}

}
