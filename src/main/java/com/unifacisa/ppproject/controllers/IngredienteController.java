package com.unifacisa.ppproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Ingrediente;
import com.unifacisa.ppproject.services.IngredienteService;

@RestController
@RequestMapping("/ingredientes")
public class IngredienteController extends BasicController<Ingrediente, IngredienteService> {

}