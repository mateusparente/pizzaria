package br.com.mateusparente.pizzaria;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.put;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.mateusparente.pizzaria.controller.RotasV1;
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
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-sources/snippets")
public class RestDocsTest {

	@Autowired
    private MockMvc mockMvc;
    
	@MockBean
    private TamanhoDaPizzaRepository tamanhoDaPizzaRepository;
	
	@MockBean
	private SaborDaPizzaRepository saborRepository;
	
	@MockBean
	private PersonalizacaoDaPizzaRepository personalizacaoRepository;
	
	@MockBean
	private PedidoService pedidoService;
	
	@Test
	public void deveriaListarTamanhosDePizza() throws Exception {
		
		List<TamanhoDaPizza> tamanhos = new ArrayList<>();
		TamanhoDaPizza tamanhoDaPizza1 = new TamanhoDaPizza();
		tamanhoDaPizza1.setDescricao("Pequena");
		tamanhoDaPizza1.setId(1);
		tamanhoDaPizza1.setValor(new BigDecimal("20.00"));
		tamanhoDaPizza1.setTempoDePreparo(15);
		
		TamanhoDaPizza tamanhoDaPizza2 = new TamanhoDaPizza();
		tamanhoDaPizza2.setDescricao("Média");
		tamanhoDaPizza2.setId(2);
		tamanhoDaPizza2.setValor(new BigDecimal("30.00"));
		tamanhoDaPizza2.setTempoDePreparo(20);
		
		TamanhoDaPizza tamanhoDaPizza3 = new TamanhoDaPizza();
		tamanhoDaPizza3.setDescricao("Grande");
		tamanhoDaPizza3.setId(3);
		tamanhoDaPizza3.setValor(new BigDecimal("40.00"));
		tamanhoDaPizza3.setTempoDePreparo(25);
		
		tamanhos.add(tamanhoDaPizza1);
		tamanhos.add(tamanhoDaPizza2);
		tamanhos.add(tamanhoDaPizza3);
		
		when(tamanhoDaPizzaRepository.findAll()).thenReturn(tamanhos);
		    
		mockMvc.perform(get(RotasV1.TAMANHO_DA_PIZZA)
			   .accept(MediaType.APPLICATION_JSON))
		       .andExpect(status().isOk())
		       .andDo(document("{methodName}"));
		    
	}
	
	@Test
	public void deveriaListarSaboresDePizza() throws Exception {
		
		List<SaborDaPizza> sabores = new ArrayList<>();
		
		SaborDaPizza sabor1 = new SaborDaPizza();
		sabor1.setDescricao("Calabresa");
		sabor1.setId(1);
		sabor1.setTempoAdicional(0);
		
		SaborDaPizza sabor2 = new SaborDaPizza();
		sabor2.setDescricao("Marguerita");
		sabor2.setId(2);
		sabor2.setTempoAdicional(0);
		
		SaborDaPizza sabor3 = new SaborDaPizza();
		sabor3.setDescricao("Portuguesa");
		sabor3.setId(3);
		sabor3.setTempoAdicional(5);
		
		sabores.add(sabor1);
		sabores.add(sabor2);
		sabores.add(sabor3);
		
		when(saborRepository.findAll()).thenReturn(sabores);
		    
		mockMvc.perform(get(RotasV1.SABOR_DA_PIZZA)
			   .accept(MediaType.APPLICATION_JSON))
		       .andExpect(status().isOk())
		       .andDo(document("{methodName}"));
		    
	}
	
	@Test
	public void deveriaListarPersonalizacoesDePizza() throws Exception {
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		PersonalizacaoDaPizza personalizacao1 = new PersonalizacaoDaPizza();
		personalizacao1.setDescricao("Extra bacon");
		personalizacao1.setId(1);
		personalizacao1.setTempoAdicional(0);
		personalizacao1.setValorAdicional(new BigDecimal("3.00"));
		
		PersonalizacaoDaPizza personalizacao2 = new PersonalizacaoDaPizza();
		personalizacao2.setDescricao("Sem cebola");
		personalizacao2.setId(2);
		personalizacao2.setTempoAdicional(0);
		personalizacao2.setValorAdicional(new BigDecimal("0.00"));
		
		PersonalizacaoDaPizza personalizacao3 = new PersonalizacaoDaPizza();
		personalizacao3.setDescricao("Borda recheada");
		personalizacao3.setId(3);
		personalizacao3.setTempoAdicional(5);
		personalizacao3.setValorAdicional(new BigDecimal("5.00"));
		
		personalizacoes.add(personalizacao1);
		personalizacoes.add(personalizacao2);
		personalizacoes.add(personalizacao3);
		
		when(personalizacaoRepository.findAll()).thenReturn(personalizacoes);
		    
		mockMvc.perform(get(RotasV1.PERSONALIZACAO_DA_PIZZA)
			   .accept(MediaType.APPLICATION_JSON))
		       .andExpect(status().isOk())
		       .andDo(document("{methodName}"));
		    
	}
	
	@Test
	public void deveriaBuscarPedidoPorID() throws Exception{
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		TamanhoDaPizza tamanhoDaPizza1 = new TamanhoDaPizza();
		tamanhoDaPizza1.setDescricao("Pequena");
		tamanhoDaPizza1.setId(1);
		tamanhoDaPizza1.setValor(new BigDecimal("20.00"));
		tamanhoDaPizza1.setTempoDePreparo(15);
		
		SaborDaPizza sabor1 = new SaborDaPizza();
		sabor1.setDescricao("Calabresa");
		sabor1.setId(1);
		sabor1.setTempoAdicional(0);
		
		PersonalizacaoDaPizza personalizacao1 = new PersonalizacaoDaPizza();
		personalizacao1.setDescricao("Extra bacon");
		personalizacao1.setId(1);
		personalizacao1.setTempoAdicional(0);
		personalizacao1.setValorAdicional(new BigDecimal("3.00"));
		
		personalizacoes.add(personalizacao1);
		
		Pizza pizza = new Pizza();
		pizza.setId(1L);
		pizza.setPersonalizacoes(personalizacoes);
		pizza.setSabor(sabor1);
		pizza.setTamanho(tamanhoDaPizza1);
		
		Pedido pedido = new Pedido();
		pedido.setId(1L);
		pedido.setPizza(pizza);
		pedido.setValorFinal(new BigDecimal("23.00"));
		pedido.setTempoDePreparo(15);
		
		when(pedidoService.buscarPorID(any(Long.class))).thenReturn(Optional.of(pedido));
		
		mockMvc.perform(get(RotasV1.PEDIDO + RotasV1.ID, 1)
			   .accept(MediaType.APPLICATION_JSON))
		       .andExpect(status().isOk())
		       .andDo(document("{methodName}", 
		    		   pathParameters(
		    				   parameterWithName("id").description("ID do Pedido")
		    	)));
	}
	
	@Test
	public void deveriaSalvarPedido() throws Exception {
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		TamanhoDaPizza tamanhoDaPizza1 = new TamanhoDaPizza();
		tamanhoDaPizza1.setDescricao("Pequena");
		tamanhoDaPizza1.setId(1);
		tamanhoDaPizza1.setValor(new BigDecimal("20.00"));
		tamanhoDaPizza1.setTempoDePreparo(15);
		
		SaborDaPizza sabor1 = new SaborDaPizza();
		sabor1.setDescricao("Calabresa");
		sabor1.setId(1);
		sabor1.setTempoAdicional(0);
		
		PersonalizacaoDaPizza personalizacao1 = new PersonalizacaoDaPizza();
		personalizacao1.setDescricao("Extra bacon");
		personalizacao1.setId(1);
		personalizacao1.setTempoAdicional(0);
		personalizacao1.setValorAdicional(new BigDecimal("3.00"));
		
		personalizacoes.add(personalizacao1);
		
		Pizza pizza = new Pizza();
		pizza.setId(1L);
		pizza.setPersonalizacoes(personalizacoes);
		pizza.setSabor(sabor1);
		pizza.setTamanho(tamanhoDaPizza1);
		
		Pedido pedido = new Pedido();
		pedido.setId(1L);
		pedido.setPizza(pizza);
		pedido.setValorFinal(new BigDecimal("23.00"));
		pedido.setTempoDePreparo(15);
		
		when(pedidoService.salvar(any(Pedido.class))).thenReturn(pedido);
		
		mockMvc.perform(post(RotasV1.PEDIDO)
			   .content(carregarJsonFile("pedido-exemplo.json"))
			   .contentType(MediaType.APPLICATION_JSON)
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isCreated())
			   .andDo(document("{methodName}"));
	}
	
	@Test
	public void deveriaAtualizarPedido() throws Exception {
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		TamanhoDaPizza tamanhoDaPizza1 = new TamanhoDaPizza();
		tamanhoDaPizza1.setDescricao("Pequena");
		tamanhoDaPizza1.setId(1);
		tamanhoDaPizza1.setValor(new BigDecimal("20.00"));
		tamanhoDaPizza1.setTempoDePreparo(15);
		
		SaborDaPizza sabor1 = new SaborDaPizza();
		sabor1.setDescricao("Calabresa");
		sabor1.setId(1);
		sabor1.setTempoAdicional(0);
		
		PersonalizacaoDaPizza personalizacao1 = new PersonalizacaoDaPizza();
		personalizacao1.setDescricao("Extra bacon");
		personalizacao1.setId(1);
		personalizacao1.setTempoAdicional(0);
		personalizacao1.setValorAdicional(new BigDecimal("3.00"));
		
		personalizacoes.add(personalizacao1);
		
		Pizza pizza = new Pizza();
		pizza.setId(1L);
		pizza.setPersonalizacoes(personalizacoes);
		pizza.setSabor(sabor1);
		pizza.setTamanho(tamanhoDaPizza1);
		
		Pedido pedido = new Pedido();
		pedido.setId(1L);
		pedido.setPizza(pizza);
		pedido.setValorFinal(new BigDecimal("23.00"));
		pedido.setTempoDePreparo(15);
		
		when(pedidoService.salvar(any(Pedido.class))).thenReturn(pedido);
		
		mockMvc.perform(put(RotasV1.PEDIDO)
			   .content(carregarJsonFile("pedido-exemplo-com-id.json"))
			   .contentType(MediaType.APPLICATION_JSON)
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk())
			   .andDo(document("{methodName}"));
	}
	
	@Test
	public void deveriaCalcularTotaisDoPedido() throws Exception {
		
		List<PersonalizacaoDaPizza> personalizacoes = new ArrayList<>();
		
		TamanhoDaPizza tamanhoDaPizza1 = new TamanhoDaPizza();
		tamanhoDaPizza1.setDescricao("Pequena");
		tamanhoDaPizza1.setId(1);
		tamanhoDaPizza1.setValor(new BigDecimal("20.00"));
		tamanhoDaPizza1.setTempoDePreparo(15);
		
		SaborDaPizza sabor1 = new SaborDaPizza();
		sabor1.setDescricao("Calabresa");
		sabor1.setId(1);
		sabor1.setTempoAdicional(0);
		
		PersonalizacaoDaPizza personalizacao1 = new PersonalizacaoDaPizza();
		personalizacao1.setDescricao("Extra bacon");
		personalizacao1.setId(1);
		personalizacao1.setTempoAdicional(0);
		personalizacao1.setValorAdicional(new BigDecimal("3.00"));
		
		personalizacoes.add(personalizacao1);
		
		Pizza pizza = new Pizza();
		pizza.setId(1L);
		pizza.setPersonalizacoes(personalizacoes);
		pizza.setSabor(sabor1);
		pizza.setTamanho(tamanhoDaPizza1);
		
		Pedido pedido = new Pedido();
		pedido.setId(1L);
		pedido.setPizza(pizza);
		pedido.setValorFinal(new BigDecimal("23.00"));
		pedido.setTempoDePreparo(15);
		
		when(pedidoService.salvar(any(Pedido.class))).thenReturn(pedido);
		
		mockMvc.perform(post(RotasV1.PEDIDO + RotasV1.CALCULAR_TOTAIS)
			   .content(carregarJsonFile("pedido-exemplo-com-id.json"))
			   .contentType(MediaType.APPLICATION_JSON)
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk())
			   .andExpect(content().json(carregarJsonFile("pedido-exemplo-com-id-totais.json")))
			   .andDo(document("{methodName}"));
	}
	
	private String carregarJsonFile(String file) {
		try {
			return FileUtils.readFileToString(new File("src/test/java/br/com/mateusparente/pizzaria/arquivos/" + file), "UTF-8");
		} catch (IOException e) {
			return null;
		}
	}
	
}