package com.unifacisa.ppproject.models.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.unifacisa.ppproject.interfaces.Identificable;

import lombok.Data;

@Entity
@Data
public class Pedido implements Identificable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private Usuario dono;
	@OneToMany
	@Column(nullable = false)
	private List<Bebida> bebidas;
	@OneToMany
	@Column(nullable = false)
	private List<Prato> pratos;
	
}
