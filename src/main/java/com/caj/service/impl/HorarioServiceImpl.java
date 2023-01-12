package com.caj.service.impl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.caj.dao.IHorarioDAO;
import com.caj.dao.IMedicoHorarioDAO;
import com.caj.dto.RegistrarHorarioDTO;
import com.caj.model.Horario;
import com.caj.model.Medico;
import com.caj.model.MedicoHorario;
import com.caj.service.IHorarioService;

@Service
public class HorarioServiceImpl implements IHorarioService {
	
	@Autowired
	private IHorarioDAO dao;
	
	@Autowired
	private IMedicoHorarioDAO medhordao;

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
		medicoHorario.setMedico(medico);
		medicoHorario.setHorario(horario);
		dao.save(horario);
		medhordao.save(medicoHorario);
		
		return registrarHorarioDto.getHorario();
	}

}
