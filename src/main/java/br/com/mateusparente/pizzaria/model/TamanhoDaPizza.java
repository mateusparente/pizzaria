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
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="PIZZA_TAMANHO")
public class TamanhoDaPizza extends ApiModel {

	@Id
	@NotNull(message = "ID do tamanho da Pizza não enviado")
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="DESCRICAO", nullable = false)
	private String descricao;
	
	@NotNull(message = "Valor do tamanho da Pizza não enviado")
	@Column(name="VALOR", nullable = false, precision = 15, scale = 2)
	private BigDecimal valor;
	
	@NotNull(message = "Tempo de preparo do tamanho da Pizza não enviado")
	@Column(name="TEMPO_PREPARO", nullable = false)
	private Integer tempoDePreparo;
	
}
