package com.unifacisa.ppproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Prato;
import com.unifacisa.ppproject.services.PratoService;

@Controller
@RequestMapping("/pratos")
public class PratoController extends BasicController<Prato, PratoService> {

}