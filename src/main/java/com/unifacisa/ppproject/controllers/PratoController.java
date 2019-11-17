package com.unifacisa.ppproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Prato;
import com.unifacisa.ppproject.services.PratoService;

@RestController
@RequestMapping("/pratos")
public class PratoController extends BasicController<Prato, PratoService> {

}