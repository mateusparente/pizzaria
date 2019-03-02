package br.com.mateusparente.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.pizzaria.model.TamanhoDaPizza;

public interface TamanhoDaPizzaRepository extends JpaRepository<TamanhoDaPizza,Integer> {

}
