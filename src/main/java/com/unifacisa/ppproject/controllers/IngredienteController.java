package com.unifacisa.ppproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Ingrediente;
import com.unifacisa.ppproject.services.IngredienteService;

@Controller
@RequestMapping("/ingredientes")
public class IngredienteController extends BasicController<Ingrediente, IngredienteService> {

}