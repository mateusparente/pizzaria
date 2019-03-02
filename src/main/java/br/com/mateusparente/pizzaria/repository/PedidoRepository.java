package br.com.mateusparente.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.pizzaria.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {

}
