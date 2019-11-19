package com.unifacisa.ppproject.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.ppproject.abstractions.BasicService;
import com.unifacisa.ppproject.exceptions.BadRequestException;
import com.unifacisa.ppproject.models.entities.Ingrediente;
import com.unifacisa.ppproject.models.entities.IngredienteQtd;
import com.unifacisa.ppproject.models.entities.Prato;
import com.unifacisa.ppproject.repositories.IngredienteRepository;
import com.unifacisa.ppproject.repositories.PratoRepository;

@Service
public class PratoService extends BasicService<Prato, PratoRepository> {
	
	@Autowired
	private IngredienteRepository rep;
	
	@Override
	public Prato post(Prato element) {
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
