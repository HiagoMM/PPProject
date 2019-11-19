package com.unifacisa.ppproject.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.exceptions.BadRequestException;
import com.unifacisa.ppproject.models.entities.Bebida;
import com.unifacisa.ppproject.models.entities.Ingrediente;
import com.unifacisa.ppproject.models.entities.IngredienteQtd;
import com.unifacisa.ppproject.repositories.BebidaRepository;
import com.unifacisa.ppproject.repositories.IngredienteRepository;

@Service
public class BebidaService extends BasicService<Bebida, BebidaRepository> {

	@Autowired
	private IngredienteRepository rep;

	@Override
	public Bebida post(Bebida element) {
		List<IngredienteQtd> ingredientes = element.getIngredientes();

		List<Long> ingredienteIds = ingredientes.stream().map(e -> e.getIngrediente().getId())
				.collect(Collectors.toList());
		Map<Long, Ingrediente> ingredientesMap = new HashMap<Long, Ingrediente>();

		rep.findAllById(ingredienteIds).forEach(ingrediente -> ingredientesMap.put(ingrediente.getId(), ingrediente));

		element.setPreco(ingredientes.stream().mapToDouble(e -> {
			try {
				return ingredientesMap.get(e.getIngrediente().getId()).getPreco() * e.getQtd();
			} catch (NullPointerException ex) {
				throw new BadRequestException("Ingrediente " + e.getIngrediente().getId() + " não encontrado");
			}

		}).sum());
		return super.post(element);
	}
}
