package com.caj.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.caj.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario>{
	
	Usuario findUserById(Integer id);
	
	UserDetails loadUserById(Integer idUser) throws UsernameNotFoundException;

}
