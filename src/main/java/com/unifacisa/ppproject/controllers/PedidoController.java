package com.unifacisa.ppproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unifacisa.ppproject.abstractions.BasicController;
import com.unifacisa.ppproject.models.entities.Pedido;
import com.unifacisa.ppproject.services.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController extends BasicController<Pedido, PedidoService> {

}