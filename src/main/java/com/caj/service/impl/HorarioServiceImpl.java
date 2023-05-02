package com.caj.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caj.dao.IHorarioDAO;
import com.caj.dao.IMedicoHorarioDAO;
import com.caj.dao.ITurnoDAO;
import com.caj.dto.RegistrarHorarioDTO;
import com.caj.model.Horario;
import com.caj.model.Medico;
import com.caj.model.MedicoHorario;
import com.caj.model.Turno;
import com.caj.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService {
	
	@Autowired
	private IHorarioDAO dao;
	
	@Autowired
	private IMedicoHorarioDAO medhordao;
	
	@Autowired
	private ITurnoDAO turnoDAO;

	@Override
	public Horario registrar(Horario t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public Horario modificar(Horario t) {
		// TODO Auto-generated method stub
		return dao.save(t);
	}

	@Override
	public List<Horario> listar() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Horario> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	
	@Transactional
	@Override
	public Horario registrarHorario(RegistrarHorarioDTO registrarHorarioDto) {
		// TODO Auto-generated method stub
		MedicoHorario medicoHorario = registrarHorarioDto.getMedicoHorario();
		Medico medico = registrarHorarioDto.getMedico();
		Horario horario = registrarHorarioDto.getHorario();
		LocalDate tiempo = horario.getFechaInicio();
		
		System.out.println("id_medico_horario : " + registrarHorarioDto.getMedicoHorario().getIdMedicoHorario());
		
		LocalDateTime start = LocalDateTime.now();
		LocalDateTime end = start;
		Duration duration = Duration.ofHours(5);

		while (Duration.between(start, end).compareTo(duration) < 0) {
		    end = end.plusMinutes(30);
		    //System.out.println(" variable end : " + end);
		}
		
		
		
		
		
		System.out.println("tiempo : " + tiempo);
		System.out.println("tiempo sumado : " + tiempo.plusDays(3));
		tiempo.plusDays(1);
		
		medicoHorario.setMedico(medico);
		medicoHorario.setHorario(horario);
		dao.save(horario);
		medhordao.save(medicoHorario);
		System.out.println("id_medico_horario : " + registrarHorarioDto.getMedicoHorario().getIdMedicoHorario());
		LocalDateTime start1 = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(), 8, 0);
		LocalDateTime end1 = LocalDateTime.of(LocalDateTime.now().getYear(), LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth(), 20, 00);
		List<Turno> turnos = new ArrayList<Turno>();
		while (start1.isBefore(end1)) {
			Turno t = new Turno();
		    t.setDia_semana("01");
		    t.setFechaInicio(start1);
		    start1 = start1.plusMinutes(15);
		    t.setFechaFin(start1);
		    t.setMedicoHorario(medicoHorario);
		    
		    turnos.add(t);
		    System.out.println(" variable start1 : " + start1);
		    
		}
		
		turnoDAO.saveAllAndFlush(turnos);
		return registrarHorarioDto.getHorario();
	}

}
