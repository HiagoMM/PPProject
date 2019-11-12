package com.unifacisa.ppproject.abstractions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.unifacisa.ppproject.exceptions.BadRequestException;
import com.unifacisa.ppproject.interfaces.Identificable;
import com.unifacisa.ppproject.interfaces.ServiceInterface;


public abstract class BasicService<T extends Identificable,R extends PagingAndSortingRepository<T, Long>> implements ServiceInterface<T>{
	
	@Autowired
	private R rep;

	public T getById(Long id) {
		return rep.findById(id).orElseThrow(() -> new BadRequestException("Id não encontrado"));
	}

	public List<T> getAll() {
		List<T> lista = new ArrayList<T>();
		rep.findAll().forEach(lista::add);
		return lista;
	}

	public T putById(Long id, T element) {
		element.setId(id);
		return rep.save(element);
	}

	public T post(T element) {
		return rep.save(element);
	}

	public void deleteById(Long id) {
		rep.deleteById(id);
	}
	
	
}
