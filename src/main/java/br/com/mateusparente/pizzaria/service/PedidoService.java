package br.com.mateusparente.pizzaria.service;

import java.util.List;
import java.util.Optional;

import br.com.mateusparente.pizzaria.model.Pedido;

public interface PedidoService {

	public Pedido salvar(Pedido pedido);
	public Optional<Pedido> buscarPorID(Long id);
	public List<Pedido> listarTodos();
	
}