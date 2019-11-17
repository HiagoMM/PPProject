package com.unifacisa.ppproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Pedido;
import com.unifacisa.ppproject.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BasicController<Pedido, PedidoService> {

}