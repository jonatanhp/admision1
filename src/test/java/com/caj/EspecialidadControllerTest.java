package com.caj;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.http.ResponseEntity;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.caj.controller.EspecialidadController;
import com.caj.dao.IEspecialidadDAO;
import com.caj.model.Especialidad;
import com.caj.service.IEspecialidadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EspecialidadControllerTest {
	
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	ObjectWriter objectWriter = objectMapper.writer();
	
	
	
	@Mock
	
	private IEspecialidadService service;
	
	@Mock
	private IEspecialidadDAO dao;
	
	
	@InjectMocks
	private EspecialidadController controller;
	
	public MockMvc mockMvc;
	
	Especialidad registro1 = new  Especialidad(8, "esp1");
	
	Especialidad registro2 = new  Especialidad(10,"esp2");
	
	
	
	
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void getAllEspecialidades_succes() throws  Exception{
		
		
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
	            .andExpect(jsonPath("$.name").value("esp1"))
	            
	            .andExpect(jsonPath("$", notNullValue()))
	            //.andExpect(jsonPath("$.name", is("gg")))
	            ;
	   
	    Mockito.verify(service).listarPorId(8);
	    Mockito.verify(service,
	    Mockito.times(1)).listarPorId(8);

	}
	
	
	
	
	
	/*
	 * @Test void addEspecialidadTests() throws Exception {
	 * this.mockMvc.perform(MockMvcRequestBuilders.post(“/author/add”)
	 * .content(“{\”bio\”:\”this is my bio\”,\”name\”: \”John Mark\”,\”url\”:
	 * \”www.johnmark.com\”}”)
	 * .contentType(MediaType.APPLICATION_JSON)).andExpect(stat us().isOk());
	 * Mockito.verify(authorService, Mockito.times(1)).add(anyObject());
	 * Mockito.verifyNoMoreInteractions(authorService); }
	 */
	 
	
	/*
	 * @Test public void addEspecialidadTest() throws Exception{
	 * 
	 * Especialidad sp = new Especialidad(); LocalDate hoy = LocalDate.now();
	 * LocalTime ahora = LocalTime.now();
	 * 
	 * LocalDateTime fecha = LocalDateTime.of(hoy, ahora); sp.setIdEspecialidad(12);
	 * sp.setName("chhhc"); sp.setFechaCreacion(fecha); String jsonString =
	 * "{\"firstName\":\"John\",\"lastName\":\"Smith\",\"age\":10,\"address\":{\"streetName\":\"Example Street\",\"streetNumber\":\"10A\",\"postalCode\":\"1QW34\",\"city\":\"Timisoara\",\"country\":\"Romania\"}}"
	 * ;
	 * 
	 * //Mockito.when(service.registrar(sp)).thenReturn(sp);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * String cont = objectWriter.writeValueAsString(sp);
	 * 
	 * System.out.println("contenido : " + cont);
	 * //Mockito.when(service.registrar(sp)).thenReturn(sp);
	 * //Mockito.doReturn(sp).when(service).registrar(sp);
	 * MockHttpServletRequestBuilder req =
	 * MockMvcRequestBuilders.post("/especialidades").content(cont)
	 * .contentType(MediaType.APPLICATION_JSON) .accept(MediaType.APPLICATION_JSON)
	 * ;
	 * 
	 * 
	 * mockMvc.perform(req)
	 * 
	 * .andExpect(status().isOk()) ; }
	 */
	 
	
	

}
