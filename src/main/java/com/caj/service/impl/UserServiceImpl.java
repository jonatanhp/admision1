package com.caj.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.caj.dao.IUserDAO;
import com.caj.model.Rol;
import com.caj.model.Usuario;
import com.caj.service.IUsuarioService;

@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, IUsuarioService {
	
	@Autowired
	private IUserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userDAO.findUserByUsername(username); //from usuario where username := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		/*user.getRoles().forEach( role -> {
			authorities.add(new SimpleGrantedAuthority(role.getNombre()));
		}
		);*/
		
		List<Rol> roles = user.getRoles();
		
		for(Rol r : roles) {
			
			authorities.add(new SimpleGrantedAuthority(r.getNombreRol()));
			
		}
		
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
		
		return userDetails;
	}
	
	
	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return userDAO.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return userDAO.save(t);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Usuario> listarPorId(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		userDAO.deleteById(id);
		
	}


	@Override
	public Usuario findUserById(Integer id) {
		// TODO Auto-generated method stub
		
		return userDAO.findUserById(id);
	}


	@Override
	public UserDetails loadUserById(Integer idUser) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario user = userDAO.findUserById(idUser); //from usuario where username := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", idUser));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		/*user.getRoles().forEach( role -> {
			authorities.add(new SimpleGrantedAuthority(role.getNombre()));
		}
		);*/
		
		List<Rol> roles = user.getRoles();
		
		for(Rol r : roles) {
			
			authorities.add(new SimpleGrantedAuthority(r.getNombreRol()));
			
		}
		
		
		UserDetails userDetails = new User(user.getUsername(), user.getPassword(), authorities);
		
		return userDetails;
	}


	

	
}
