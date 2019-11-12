package com.unifacisa.ppproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Bebida;
import com.unifacisa.ppproject.services.BebidaService;

@Controller
@RequestMapping("/bebidas")
public class BebidaController extends BasicController<Bebida, BebidaService> {

}
