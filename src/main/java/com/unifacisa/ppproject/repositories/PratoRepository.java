package com.unifacisa.ppproject.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.ppproject.models.entities.Prato;

@Repository
public interface PratoRepository extends PagingAndSortingRepository<Prato, Long> {

}
