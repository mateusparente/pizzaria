package br.com.mateusparente.pizzaria.model;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static br.com.mateusparente.pizzaria.util.CollectionsUtils.defaultList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="PEDIDO")
public class Pedido extends ApiModel {

	@Id
	@Column(nullable = false, name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@JsonIgnoreProperties("pedido")
	@NotNull(message = "Nenhuma pizza no pedido")
	@OneToOne(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
	private Pizza pizza;
	
	@Column(name = "TEMPO_PREPARO", nullable = false, precision = 2, scale = 0)
	private Integer tempoDePreparo;
	
	@Column(name = "VALOR_FINAL", nullable = false, precision = 15, scale = 2)
	private BigDecimal valorFinal;

	public void prepararParaSalvar(){
		resolverReferencias();
		calcularValorFinal();
		calcularTempoDePreparo();
	}
	
	private void calcularValorFinal() {
		
		BigDecimal valorCalculado = BigDecimal.ZERO
						.add(pizza.getTamanho().getValor())
						.add(defaultList(pizza.getPersonalizacoes())
								  .stream()
								  .map(PersonalizacaoDaPizza::getValorAdicional)
								  .reduce(BigDecimal.ZERO, BigDecimal::add));
		
		setValorFinal(valorCalculado);
	}
	
	private void calcularTempoDePreparo() {

		Integer tempoCalculado = 0;
		
		tempoCalculado += pizza.getTamanho().getTempoDePreparo();
		tempoCalculado += pizza.getSabor().getTempoAdicional();
		tempoCalculado += defaultList(pizza.getPersonalizacoes())
				   			   .stream()
				   			   .mapToInt(PersonalizacaoDaPizza::getTempoAdicional)
				   			   .sum();
		
		setTempoDePreparo(tempoCalculado);
	}

	private void resolverReferencias() {
		pizza.setPedido(this);
	}
	
}