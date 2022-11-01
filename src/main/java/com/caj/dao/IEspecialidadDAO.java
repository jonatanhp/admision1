package com.caj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.caj.model.Especialidad;
import com.caj.model.Medico;

public interface IEspecialidadDAO extends JpaRepository<Especialidad, Integer> {
	
	
	
	/*@Query("from  Medico m where m.consultation.idConsultation=:idConsulta")
	List<Medico> listarMedicosPorEspecialidad(@Param("idEspecialidad") Integer idEspecialidad);*/
	
	
	@Query(value = "select id_medico from medico_especialidad where id_especialidad =:idEspecialidad", nativeQuery = true)
	List<Integer> listarIdMedicosPorEspecialidad(@Param("idEspecialidad") Integer idEspecialidad);
	
	
	@Query(value = "select * from persona where id_user =:idMedico ", nativeQuery = true)
	List<Object[]> listarMedicosPorId(@Param("idMedico") Integer idMedico);
	
	@Query(value = "select * from persona where id_user =:idMedico ", nativeQuery = true)
	Medico listarMedicosPorId2(@Param("idMedico") Integer idMedico);
	
	
	
	

}
