package com.unifacisa.ppproject.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.ppproject.models.entities.Pedido;

@Repository
public interface PedidoRepository extends PagingAndSortingRepository<Pedido, Long> {

}
