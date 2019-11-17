package com.unifacisa.ppproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Bebida;
import com.unifacisa.ppproject.services.BebidaService;

@RestController
@RequestMapping("/bebidas")
public class BebidaController extends BasicController<Bebida, BebidaService> {

}
