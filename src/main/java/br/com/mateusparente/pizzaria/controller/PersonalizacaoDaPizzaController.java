package br.com.mateusparente.pizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateusparente.pizzaria.model.PersonalizacaoDaPizza;
import br.com.mateusparente.pizzaria.repository.PersonalizacaoDaPizzaRepository;

@RestController
@RequestMapping(RotasV1.PERSONALIZACAO_DA_PIZZA)
public class PersonalizacaoDaPizzaController {

	@Autowired
	private PersonalizacaoDaPizzaRepository repository;
	
	@GetMapping
    public List<PersonalizacaoDaPizza> findAll() {
		return repository.findAll();
	}
	
}