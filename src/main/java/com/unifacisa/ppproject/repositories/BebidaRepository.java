package com.unifacisa.ppproject.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.ppproject.models.entities.Bebida;

@Repository
public interface BebidaRepository extends PagingAndSortingRepository<Bebida, Long> {

}
