package com.unifacisa.ppproject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Usuario;
import com.unifacisa.ppproject.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BasicController<Usuario, UsuarioService> {
	
	@Autowired
	private UsuarioService serv;
	
	@PostMapping("admin")
	public ResponseEntity<Usuario> postAdmin(@Valid @RequestBody Usuario element) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.postAdmin(element));
	}
	@PostMapping("cliente")
	public ResponseEntity<Usuario> postCliente(@Valid @RequestBody Usuario element) {
		return ResponseEntity.status(HttpStatus.CREATED).body(serv.postCliente(element));
	}
}