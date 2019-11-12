package com.unifacisa.ppproject.interfaces;

import java.util.List;

public interface ServiceInterface<T> {
	
	public T getById(Long id);
	public List<T> getAll();
	public T putById(Long id,T element);
	public T post(T element);
	public void deleteById(Long id);
	
}
