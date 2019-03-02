package br.com.mateusparente.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.pizzaria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}