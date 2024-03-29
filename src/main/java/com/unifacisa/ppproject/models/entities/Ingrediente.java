package com.unifacisa.ppproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.unifacisa.ppproject.interfaces.Identificable;

import lombok.Data;

@Entity
@Data
public class Ingrediente implements Identificable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotNull
	private Double preco;
	
}
