package com.unifacisa.ppproject.models.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.unifacisa.ppproject.interfaces.Identificable;

import lombok.Data;

@Data
@Entity
public class Prato implements Identificable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	private Double preco;
	@OneToMany(cascade = CascadeType.ALL)
	@Column(nullable = false)
	private List<IngredienteQtd> ingredientes;
	
}
