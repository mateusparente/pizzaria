package br.com.mateusparente.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.pizzaria.model.PersonalizacaoDaPizza;

public interface PersonalizacaoDaPizzaRepository extends JpaRepository<PersonalizacaoDaPizza,Integer> {

}
