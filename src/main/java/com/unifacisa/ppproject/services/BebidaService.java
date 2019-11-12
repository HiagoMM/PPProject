package com.unifacisa.ppproject.services;

import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.models.entities.Bebida;
import com.unifacisa.ppproject.repositories.BebidaRepository;

@Service
public class BebidaService extends BasicService<Bebida, BebidaRepository> {

}
