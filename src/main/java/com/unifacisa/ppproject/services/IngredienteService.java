package com.unifacisa.ppproject.services;

import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.models.entities.Ingrediente;
import com.unifacisa.ppproject.repositories.IngredienteRepository;

@Service
public class IngredienteService extends BasicService<Ingrediente, IngredienteRepository>{

}
