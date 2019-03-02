package br.com.mateusparente.pizzaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mateusparente.pizzaria.RotasV1;

@RestController
@RequestMapping(RotasV1.DEMO)
public class DefaultController {

	@GetMapping
    public String index() {
		return "Pizzaria API";
	}
	
}