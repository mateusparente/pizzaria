package br.com.mateusparente.pizzaria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateusparente.pizzaria.model.Pedido;
import br.com.mateusparente.pizzaria.repository.PedidoRepository;
import br.com.mateusparente.pizzaria.repository.PersonalizacaoDaPizzaRepository;
import br.com.mateusparente.pizzaria.repository.SaborDaPizzaRepository;
import br.com.mateusparente.pizzaria.repository.TamanhoDaPizzaRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private TamanhoDaPizzaRepository tamanhoRepository;
	
	@Autowired
	private SaborDaPizzaRepository saborRepository;
	
	@Autowired
	private PersonalizacaoDaPizzaRepository personalizacaoRepository;
	
	@Override
	public Pedido saveAndFlush(Pedido pedido) {
		return pedidoRepository.saveAndFlush(pedido);
	}
	
}