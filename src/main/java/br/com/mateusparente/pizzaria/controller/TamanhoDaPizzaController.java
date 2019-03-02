package br.com.mateusparente.pizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateusparente.pizzaria.model.TamanhoDaPizza;
import br.com.mateusparente.pizzaria.repository.TamanhoDaPizzaRepository;

@RestController
@RequestMapping(RotasV1.TAMANHO_DA_PIZZA)
public class TamanhoDaPizzaController {

	@Autowired
	private TamanhoDaPizzaRepository repository;
	
	@GetMapping
    public List<TamanhoDaPizza> findAll() {
		return repository.findAll();
	}
	
}