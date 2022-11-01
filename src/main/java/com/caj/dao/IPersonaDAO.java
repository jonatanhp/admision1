package com.caj.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.caj.model.Persona;
import com.caj.model.Usuario;

public interface IPersonaDAO extends JpaRepository<Persona, Integer> {
	
	@Query(value = "select * from rol where id_rol = :id_rol", nativeQuery = true)
	List<Object[]> obtenerIdRol(@Param("id_rol") Integer id);
	
	
	@Query("from Persona p where p.dni =:dni or UPPER(p.nombre) like %:nombreCompleto% or UPPER(p.apelPat) like %:nombreCompleto% or UPPER(p.apelMat) like %:nombreCompleto%")
	List<Persona> buscar(@Param("dni")String dni, @Param("nombreCompleto")String nombreCompleto);
	
	@Query("from Usuario u inner join Persona p on p.id = u.idUser where p.id =:idPersona" )
	Usuario usuarioPorPersonaId(@Param("idPersona")Integer idPersona);
	
	
	
	

}