package com.unifacisa.ppproject.services;

import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.models.entities.Pedido;
import com.unifacisa.ppproject.repositories.PedidoRepository;

@Service
public class PedidoService extends BasicService<Pedido, PedidoRepository>{

}
