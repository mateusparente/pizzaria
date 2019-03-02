package br.com.mateusparente.pizzaria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RotasV1.DEMO)
public class DemoController {

	@GetMapping
    public String index() {
		return "Pizzaria API";
	}
	
}