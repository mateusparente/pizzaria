package br.com.mateusparente.pizzaria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="PEDIDO")
public class Pedido {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private Pizza pizza;
	
	@Column(name = "TEMPO_PREPARO", nullable = false, precision = 2, scale = 0)
	private Integer tempoDePreparo;
	
	@Column(name = "VALOR_FINAL", nullable = false, precision = 15, scale = 2)
	private Integer valorFinal;
	
}
