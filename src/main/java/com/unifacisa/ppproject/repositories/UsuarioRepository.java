package com.unifacisa.ppproject.repositories;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unifacisa.ppproject.models.entities.Usuario;

@Repository
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
