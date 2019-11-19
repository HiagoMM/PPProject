package com.unifacisa.ppproject.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.exceptions.BadRequestException;
import com.unifacisa.ppproject.models.entities.Usuario;
import com.unifacisa.ppproject.models.enums.RoleEnum;
import com.unifacisa.ppproject.repositories.UsuarioRepository;

@Service
public class UsuarioService extends BasicService<Usuario, UsuarioRepository> implements UserDetailsService {

	@Autowired
	private UsuarioRepository rep;

	@Autowired
	private BCryptPasswordEncoder encoder;

	public Usuario getByEmail(String email) {
		return rep.findByEmail(email).orElseThrow( () -> new BadRequestException("Usuario não encontrado") ) ;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getByEmail(username);
	}

	@Override
	public Usuario post(Usuario element) {
		element.setPassword(encoder.encode(element.getPassword()));
		element.setRole(RoleEnum.CLIENTE);
		return super.post(element);
	}
}
