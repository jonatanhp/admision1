package com.caj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caj.dao.IMedicoDAO;
import com.caj.dao.IPacienteDAO;
import com.caj.dao.IPersonaDAO;
import com.caj.dto.ActualizarRolesDTO;
import com.caj.dto.FiltroConsultaPersona;
import com.caj.dto.RegistrarPersonaGeneral;
import com.caj.dto.RegistrarPersonaParticular;
import com.caj.model.Medico;
import com.caj.model.Paciente;
import com.caj.model.Persona;
import com.caj.model.Rol;
import com.caj.model.Usuario;
import com.caj.service.IPersonaService;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDAO dao;
	
	@Autowired
	private IPacienteDAO estDao;
	
	@Autowired
	private IMedicoDAO docDao;
	
	@Override
	public Persona registrar(Persona t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Persona modificar(Persona t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Persona> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Persona> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	public Page<Persona> listarPorPagina(Pageable pageable) {
		// TODO Auto-generated method stub
		return dao.findAll(pageable);
	}

	@Transactional
	@Override
	public Persona registrarGeneral(RegistrarPersonaGeneral personaGeneralDTO) {
		// TODO Auto-generated method stub
		Paciente paciente = personaGeneralDTO.getPaciente();
		List<Rol> listaRoles = new ArrayList<>();
		Persona persona = personaGeneralDTO.getPersona();
		Usuario usuario = personaGeneralDTO.getUsuario();
		List<Object[]> roles = dao.obtenerIdRol(1);
		for (Object[] e : roles) {
			Rol cr = new Rol();
			cr.setIdRol(Integer.parseInt(String.valueOf(e[0])));
			cr.setDescRol(String.valueOf(e[1]));
			cr.setEstado(String.valueOf(e[2]));
			cr.setNombreRol(String.valueOf(e[3]));
			//cr.setFecha(String.valueOf(e[1]));
			System.out.println(String.valueOf(e[0]));
			System.out.println(String.valueOf(e[1]));
			System.out.println(String.valueOf(e[2]));
			System.out.println(String.valueOf(e[3]));
			listaRoles.add(cr);
		}
		
		
		//rol1.setIdRol(Integer.parseInt(String.valueOf(rol[1])));
		
		
		usuario.setRoles(listaRoles);
		persona.setUsuario(usuario);
		paciente.setPersona(personaGeneralDTO.getPersona());
		System.out.println("el paciente inicio");
		System.out.println(paciente.getPersona().getNombre());
		estDao.save(paciente);
		System.out.println("el paciente fin");
		
		dao.save(personaGeneralDTO.getPersona());
		return personaGeneralDTO.getPersona();
	}
	
	@Transactional
	@Override
	public Persona registrarParticular(RegistrarPersonaParticular personaParticularDTO) {
		// TODO Auto-generated method stub
		Medico medico = personaParticularDTO.getMedico();
		List<Rol> listaRoles = new ArrayList<>();
		Persona persona = personaParticularDTO.getPersona();
		Usuario usuario = personaParticularDTO.getUsuario();
		List<Object[]> roles = dao.obtenerIdRol(2);
		for (Object[] e : roles) {
			Rol cr = new Rol();
			cr.setIdRol(Integer.parseInt(String.valueOf(e[0])));
			cr.setDescRol(String.valueOf(e[1]));
			cr.setEstado(String.valueOf(e[2]));
			cr.setNombreRol(String.valueOf(e[3]));
			//cr.setFecha(String.valueOf(e[1]));
			System.out.println(String.valueOf(e[0]));
			System.out.println(String.valueOf(e[1]));
			System.out.println(String.valueOf(e[2]));
			System.out.println(String.valueOf(e[3]));
			listaRoles.add(cr);
		}
		
		
		//rol1.setIdRol(Integer.parseInt(String.valueOf(rol[1])));
		
		
		usuario.setRoles(listaRoles);
		persona.setUsuario(usuario);
		medico.setPersona(personaParticularDTO.getPersona());
		System.out.println("el paciente inicio");
		System.out.println(medico.getPersona().getNombre());
		docDao.save(medico);
		System.out.println("el paciente fin");
		
		dao.save(personaParticularDTO.getPersona());
		return personaParticularDTO.getPersona();
	}

	@Override
	public List<Persona> buscar(FiltroConsultaPersona filtroConsultaPersonaDTO) {
		// TODO Auto-generated method stub
		return dao.buscar(filtroConsultaPersonaDTO.getDni(), filtroConsultaPersonaDTO.getNombreCompleto());
	}

	@Override
	public Usuario usuarioPorPersonaId(Integer idPersona) {
		// TODO Auto-generated method stub
		Usuario usuario ;
		usuario = dao.usuarioPorPersonaId(idPersona);
		return usuario;
	}

	@Override
	public Usuario actualizarRoles(ActualizarRolesDTO actualizarRolesDTO) {
		Persona persona = actualizarRolesDTO.getPersona();
		Usuario usuarios = dao.usuarioPorPersonaId(persona.getId());
		List<Rol> nuevosRoles = new ArrayList<>();
		nuevosRoles = actualizarRolesDTO.getRoles();
		usuarios.setRoles(nuevosRoles);
		return usuarios;
	}
	
	 
	
	
	

}
