package br.com.mateusparente.pizzaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name="PIZZA_SABOR")
public class SaborDaPizza {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="DESCRICAO", nullable = false)
	private String descricao;
	
	@Column(name="VALOR", nullable = false)
	private Integer tempoAdicional;
	
}
