package com.unifacisa.ppproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.unifacisa.ppproject.interfaces.Identificable;

import lombok.Data;

@Entity
@Data
public class Ingrediente implements Identificable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Double preco;
}
