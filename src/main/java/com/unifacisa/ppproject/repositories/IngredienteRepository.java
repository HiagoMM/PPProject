package com.unifacisa.ppproject.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.ppproject.models.entities.Ingrediente;

@Repository
public interface IngredienteRepository extends PagingAndSortingRepository<Ingrediente, Long> {

}
