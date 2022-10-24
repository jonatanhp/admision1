package com.caj.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.caj.model.Usuario;

public interface IUserDAO extends JpaRepository<Usuario, Integer> {
	
	Usuario findUserByUsername(String username);
	
	
	@Query(value = "select * from usario where id_user =:idUser", nativeQuery = true)
	Usuario findUserById(@Param("idUser") Integer idUser);

}
