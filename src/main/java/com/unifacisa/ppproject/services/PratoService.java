package com.unifacisa.ppproject.services;

import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.models.entities.Prato;
import com.unifacisa.ppproject.repositories.PratoRepository;

@Service
public class PratoService extends BasicService<Prato, PratoRepository>{

}
