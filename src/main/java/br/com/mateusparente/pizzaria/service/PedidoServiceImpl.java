package br.com.mateusparente.pizzaria.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mateusparente.pizzaria.model.Pedido;
import br.com.mateusparente.pizzaria.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public Pedido salvar(Pedido pedido) {
		
		pedido.calcularValorFinal();
		pedido.calcularTempoDePreparo();
		pedido.resolverReferencias();
		
		return pedidoRepository.saveAndFlush(pedido);
	}
	
	@Override
	public Optional<Pedido> buscarPorID(Long id){
		return pedidoRepository.findById(id);
	}

}