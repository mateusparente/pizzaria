package br.com.mateusparente.pizzaria.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="PIZZA_PERSONALIZACAO")
public class PersonalizacaoDaPizza extends ApiModel {

	@Id
	@NotNull(message = "ID da Personalizacao da Pizza não enviado")
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DESCRICAO", nullable = false)
	private String descricao;
	
	@NotNull(message = "Valor Adicional da Personalizacao da Pizza não enviado")
	@Column(name="VALOR_ADICIONAL", nullable = false, precision = 15, scale = 2)
	private BigDecimal valorAdicional;
	
	@NotNull(message = "Tempo Adicional da Personalizacao da Pizza não enviado")
	@Column(name="TEMPO_ADICIONAL", nullable = false)
	private Integer tempoAdicional;
	
}