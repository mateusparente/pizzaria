package br.com.mateusparente.pizzaria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="PIZZA")
public class Pizza extends ApiModel {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private Pedido pedido;
	
	@Valid
	@NotNull(message = "Nenhum tamanho selecionado")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PIZZA_TAMANHO_ID", nullable = false, referencedColumnName="ID")
	private TamanhoDaPizza tamanho;
	
	@Valid
	@NotNull(message = "Nenhum sabor selecionado")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PIZZA_SABOR_ID", nullable = false, referencedColumnName="ID")
	private SaborDaPizza sabor;
	
	@Valid
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="PIZZA_PERSONALIZACAO_PIZZA", joinColumns= {@JoinColumn(name="PIZZA_ID")}, inverseJoinColumns={@JoinColumn(name="PIZZA_PERSONALIZACAO_ID")})
	private List<PersonalizacaoDaPizza> personalizacoes;
	
}
