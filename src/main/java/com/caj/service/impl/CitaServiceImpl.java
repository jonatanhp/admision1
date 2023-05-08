package com.caj.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caj.dao.ICitaDAO;
import com.caj.dao.IMedicoHorarioDAO;
import com.caj.dao.IPersonaDAO;
import com.caj.dto.RegistrarCitaDTO;
import com.caj.model.Cita;
import com.caj.model.MedicoHorario;
import com.caj.model.Paciente;
import com.caj.service.ICitaService;

@Service
public class CitaServiceImpl implements ICitaService {
	
	
	
	@Autowired
	private ICitaDAO citaDAO;
	
	
	

	@Override
	public Cita registrar(Cita t) {
		// TODO Auto-generated method stub
		return citaDAO.save(t);
	}

	@Override
	public Cita modificar(Cita t) {
		// TODO Auto-generated method stub
		return citaDAO.save(t);
	}

	@Override
	public List<Cita> listar() {
		// TODO Auto-generated method stub
		return citaDAO.findAll();
	}

	@Override
	public Optional<Cita> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return citaDAO.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		citaDAO.deleteById(id);
		
	}

	@Override
	public Cita registrarCita(RegistrarCitaDTO registrarCitaDto) {
		// TODO Auto-generated method stub
		
		Paciente paciente = registrarCitaDto.getPaciente();
		
		MedicoHorario medicoHorario = registrarCitaDto.getMedicoHorario();
		
		Cita cita = registrarCitaDto.getCita();
		
		cita.setPaciente(paciente);
		cita.setMedicoHorario(medicoHorario);
		
		
		
		return citaDAO.save(cita);
	}

}
