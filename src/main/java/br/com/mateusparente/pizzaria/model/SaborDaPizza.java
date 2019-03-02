package br.com.mateusparente.pizzaria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="PIZZA_SABOR")
public class SaborDaPizza extends ApiModel {

	@Id
	@NotNull(message = "ID do Sabor da Pizza não enviado")
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DESCRICAO", nullable = false)
	private String descricao;
	
	@NotNull(message = "Tempo Adicional do Sabor da Pizza não enviado")
	@Column(name="TEMPO_ADICIONAL", nullable = false)
	private Integer tempoAdicional;
	
}
