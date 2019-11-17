package com.unifacisa.ppproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Usuario;
import com.unifacisa.ppproject.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends BasicController<Usuario, UsuarioService> {

}