package com.caj;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.isNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.ResponseEntity;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.caj.controller.EspecialidadController;
import com.caj.dao.IEspecialidadDAO;
import com.caj.model.Especialidad;
import com.caj.service.IEspecialidadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(MockitoJUnitRunner.class)
public class EspecialidadControllerTest {
	
	private MockMvc mockMvc;
	ObjectMapper objectMapper = new ObjectMapper();
	
	ObjectWriter objectWriter = objectMapper.writer();
	
	@Mock
	private IEspecialidadService service;
	@Mock
	private IEspecialidadDAO dao;
	
	@InjectMocks
	private EspecialidadController controller;
	
	Especialidad registro1 = new  Especialidad(8, "gg");
	
	Especialidad registro2 = new  Especialidad(10,"hh");
	
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void getAllEspecialidades_succes() throws  Exception{
		System.out.println("hola");
		
		List<Especialidad> registros = new ArrayList<>(Arrays.asList(registro1,registro2));
		new ResponseEntity<List<Especialidad>>(registros, HttpStatus.OK);
		for(int i = 0 ; i<registros.size();i++) {
			System.out.println("f : " +registros.get(i).getName());
			registro1.setName("gg");
		}
		
		Mockito.when(service.listar()).thenReturn(registros);
		
		mockMvc.perform(MockMvcRequestBuilders
				.get("/especialidades")
				.contentType(MediaType.APPLICATION_JSON))
				//.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
				//.andExpect(MockMvcResultMatchers.jsonPath("$[1].name", Matchers.is("hh")))
				.andExpect(jsonPath("$[0].name").value("gg"))
				//.andExpect(jsonPath("$[1].name", is("org.springframework.test.web.servlet.result.JsonPathResultMatchers@519c6fcc")))
				.andExpect(status().isOk()
						
						
				)
				;
		
		
		
	}
	
	@Test
	public void getPatientById_success() throws Exception {
		
	    Mockito.when(service.listarPorId(8)).thenReturn(java.util.Optional.of(registro1));

	    mockMvc.perform(MockMvcRequestBuilders
	            .get("/especialidades/8")
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isOk())
	            .andExpect(jsonPath("$.name").value("gg"))
	            
	            //.andExpect(jsonPath("$", notNullValue()))
	            //.andExpect(jsonPath("$.name", is("gg")))
	            ;
	}
	
	

}
