package br.com.mateusparente.pizzaria.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;

@Getter
@Entity
@Table(name="PIZZA_PERSONALIZACAO")
public class PersonalizacaoDaPizza {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="DESCRICAO", nullable = false)
	private String descricao;
	
	@Column(name="VALOR_ADICIONAL", nullable = false, precision = 15, scale = 2)
	private BigDecimal valorAdicional;
	
	@Column(name="TEMPO_ADICIONAL", nullable = false)
	private Integer tempoAdicional;
	
}