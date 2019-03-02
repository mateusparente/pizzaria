package br.com.mateusparente.pizzaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateusparente.pizzaria.model.SaborDaPizza;
import br.com.mateusparente.pizzaria.repository.SaborDaPizzaRepository;

@RestController
@RequestMapping(RotasV1.SABOR_DA_PIZZA)
public class SaborDaPizzaController {

	@Autowired
	private SaborDaPizzaRepository repository;
	
	@GetMapping
    public List<SaborDaPizza> findAll() {
		return repository.findAll();
	}
	
}