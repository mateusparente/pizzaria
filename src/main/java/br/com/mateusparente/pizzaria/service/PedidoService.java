package br.com.mateusparente.pizzaria.service;

import br.com.mateusparente.pizzaria.model.Pedido;

public interface PedidoService {

	public Pedido saveAndFlush(Pedido pedido);
	
}
