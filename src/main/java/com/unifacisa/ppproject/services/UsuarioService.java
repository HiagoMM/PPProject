package com.unifacisa.ppproject.services;

import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.models.entities.Usuario;
import com.unifacisa.ppproject.repositories.UsuarioRepository;

@Service
public class UsuarioService extends BasicService<Usuario, UsuarioRepository> {
	
}
