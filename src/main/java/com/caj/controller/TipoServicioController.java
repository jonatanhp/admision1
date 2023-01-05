package com.caj.controller;

import java.net.URI;
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
import com.caj.model.TipoServicio;
import com.caj.service.ITipoServicioService;

@RestController
@RequestMapping("/tiposServicio")
public class TipoServicioController {

	@Autowired
	private ITipoServicioService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoServicio>> list(){
		
		List<TipoServicio> tipos_servicio = service.listar();
		return new ResponseEntity<List<TipoServicio>>(tipos_servicio, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Optional<TipoServicio>> listById(@PathVariable("id") Integer id){
		Optional<TipoServicio> tipo_servicio = service.listarPorId(id);
		EntityModel<Optional<TipoServicio>> entityModel = EntityModel.of(tipo_servicio);
		Link link = WebMvcLinkBuilder.linkTo(TipoServicioController.class).slash(tipo_servicio.get().getIdTipoServicio()).withSelfRel();
		entityModel.add(link.withRel("asdf"));
		return entityModel;
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register(@Valid @RequestBody TipoServicio t){
		TipoServicio tipo_servicio = service.registrar(t);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tipo_servicio.getIdTipoServicio()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify(@Valid @RequestBody TipoServicio t){
		service.modificar(t);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id") Integer id) {
		Optional<TipoServicio> tipo_servicio = service.listarPorId(id);
		if(!tipo_servicio.isPresent()) {
			throw new ModelNotFoundException("Id : "+ id + "no existe");
		}else {
			service.eliminar(id);
		}
	}

}
