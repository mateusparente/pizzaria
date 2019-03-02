package br.com.mateusparente.pizzaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.mateusparente.pizzaria.model.Pedido;
import br.com.mateusparente.pizzaria.model.PersonalizacaoDaPizza;
import br.com.mateusparente.pizzaria.model.Pizza;
import br.com.mateusparente.pizzaria.model.SaborDaPizza;
import br.com.mateusparente.pizzaria.model.TamanhoDaPizza;
import br.com.mateusparente.pizzaria.repository.PersonalizacaoDaPizzaRepository;
import br.com.mateusparente.pizzaria.repository.SaborDaPizzaRepository;
import br.com.mateusparente.pizzaria.repository.TamanhoDaPizzaRepository;
import br.com.mateusparente.pizzaria.service.PedidoService;

@RunWith(SpringRunner.class)
@DataJpaTest
@SqlGroup({
    @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
    @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql")})
public class PedidoServiceImplTest {

	@Autowired
	private TamanhoDaPizzaRepository tamanhoRepository;
	
	@Autowired
	private SaborDaPizzaRepository saborRepository;
	
	@Autowired
	private PersonalizacaoDaPizzaRepository personalizacaoRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	@Test
	public void deveriaSalvarPedidoCalculandoValores(){
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		TamanhoDaPizza tamanhoDaPizza = carregarTamanho("Pequena");
		SaborDaPizza saborDaPizza = carregarSabor("Calabresa");
		PersonalizacaoDaPizza personalizacaoDaPizza = carregarPersonalizacao("Extra bacon");
		personalizacoes.add(personalizacaoDaPizza);
		
		Pizza pizza = new Pizza();
		pizza.setPersonalizacoes(personalizacoes);
		pizza.setSabor(saborDaPizza);
		pizza.setTamanho(tamanhoDaPizza);
		
		Pedido pedido = new Pedido();
		pedido.setPizza(pizza);
		
		pedidoService.salvar(pedido);
		assertNotNull(pedido.getId());
		assertNotNull(pizza.getId());
		
		assertEquals(new BigDecimal("23.00"), pedido.getValorFinal());
		assertEquals(new Integer("15"), pedido.getTempoDePreparo());
		
	}
	
	@Test
	public void deveriaSalvarPedidoCalculandoValores_2(){
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		TamanhoDaPizza tamanhoDaPizza = carregarTamanho("Média");
		SaborDaPizza saborDaPizza = carregarSabor("Portuguesa");
		PersonalizacaoDaPizza personalizacaoDaPizza = carregarPersonalizacao("Borda recheada");
		personalizacoes.add(personalizacaoDaPizza);
		
		Pizza pizza = new Pizza();
		pizza.setPersonalizacoes(personalizacoes);
		pizza.setSabor(saborDaPizza);
		pizza.setTamanho(tamanhoDaPizza);
		
		Pedido pedido = new Pedido();
		pedido.setPizza(pizza);
		
		pedidoService.salvar(pedido);
		assertNotNull(pedido.getId());
		assertNotNull(pizza.getId());
		
		assertEquals(new BigDecimal("35.00"), pedido.getValorFinal());
		assertEquals(new Integer("30"), pedido.getTempoDePreparo());
		
	}

	private TamanhoDaPizza carregarTamanho(String descricao) {
		TamanhoDaPizza tamanhoDaPizza = new TamanhoDaPizza();
		tamanhoDaPizza.setDescricao(descricao);
		
		return tamanhoRepository.findOne(Example.of(tamanhoDaPizza)).get();
	}
	
	private SaborDaPizza carregarSabor(String descricao) {
		SaborDaPizza saborDaPizza = new SaborDaPizza();
		saborDaPizza.setDescricao(descricao);
		
		return saborRepository.findOne(Example.of(saborDaPizza)).get();
	}
	
	private PersonalizacaoDaPizza carregarPersonalizacao(String descricao) {
		PersonalizacaoDaPizza personalizacao = new PersonalizacaoDaPizza();
		personalizacao.setDescricao(descricao);
		
		return personalizacaoRepository.findOne(Example.of(personalizacao)).get();
	}
	
}