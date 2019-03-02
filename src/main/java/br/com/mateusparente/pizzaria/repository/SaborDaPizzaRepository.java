package br.com.mateusparente.pizzaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mateusparente.pizzaria.model.SaborDaPizza;

public interface SaborDaPizzaRepository extends JpaRepository<SaborDaPizza,Integer> {

}