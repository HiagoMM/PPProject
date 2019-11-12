package com.unifacisa.ppproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Usuario;
import com.unifacisa.ppproject.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController extends BasicController<Usuario, UsuarioService> {

}