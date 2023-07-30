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

//import com.caj.dto.RegistrarVentaDetalleDTO;
import com.caj.dto.RegistrarPersonaGeneral;
import com.caj.exception.ModelNotFoundException;
import com.caj.model.VentaDetalle;
import com.caj.model.Persona;
import com.caj.service.IVentaDetalleService;


@RestController
@RequestMapping("/venta_detalles")
public class VentaDetalleController {
	
	@Autowired
	private IVentaDetalleService service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VentaDetalle>> list(){
		List<VentaDetalle> venta_detalles = new ArrayList<>();
		venta_detalles = service.listar();
		
		return new ResponseEntity<List<VentaDetalle>>(venta_detalles, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EntityModel<Optional<VentaDetalle>> listById(@PathVariable("id") Integer id){
		Optional<VentaDetalle> venta_detalle = service.listarPorId(id);
		if(!venta_detalle.isPresent()) {
			throw new ModelNotFoundException("Id: " + id );
		}
		EntityModel<Optional<VentaDetalle>> entityModel = EntityModel.of(venta_detalle);
		VentaDetalle venta_detalle2 = venta_detalle.get();
		Link link = WebMvcLinkBuilder.linkTo(VentaDetalleController.class).slash(venta_detalle2.getIdVentaDetalle()).withSelfRel();
		entityModel.add(link.withRel("asdf"));
		return entityModel;
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> register (@Valid @RequestBody VentaDetalle n){
		VentaDetalle venta_detalle = service.registrar(n);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venta_detalle.getIdVentaDetalle()).toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	/*
	 * @PostMapping(value = "/registrar", consumes =
	 * MediaType.APPLICATION_JSON_VALUE, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public ResponseEntity<Object>
	 * registrar(@Valid @RequestBody RegistrarVentaDetalleDTO venta_detalleDTO){
	 * VentaDetalle venta_detalle = new VentaDetalle(); venta_detalle =
	 * service.registrarVentaDetalle(venta_detalleDTO);
	 * 
	 * URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (venta_detalle.getIdVentaDetalle()).toUri(); return
	 * ResponseEntity.created(location).build(); }
	 */
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> modify (@Valid @RequestBody VentaDetalle n){
		service.modificar(n);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Integer id) {
		Optional<VentaDetalle> venta_detalle = service.listarPorId(id);
		if(!venta_detalle.isPresent()) {
			throw new ModelNotFoundException("Id : " + id + "no encontraod");
		}else {
			service.eliminar(id);
		}
	}

}
