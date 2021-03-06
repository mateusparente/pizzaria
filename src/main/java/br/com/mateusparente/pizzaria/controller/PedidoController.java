package br.com.mateusparente.pizzaria.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mateusparente.pizzaria.model.Pedido;
import br.com.mateusparente.pizzaria.service.PedidoService;

@RestController
@RequestMapping(RotasV1.PEDIDO)
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping
    public List<Pedido> findAll() {
		return service.listarTodos();
	}
	
	@GetMapping(path = RotasV1.ID)
	public ResponseEntity<Pedido> buscarPorID(@PathVariable("id") Long id){
		return service.buscarPorID(id).map(p -> {
			return ResponseEntity.ok(p);
		}).orElse(ResponseEntity.noContent().build());
	}
	
	@PostMapping
	public ResponseEntity<Object> salvar(@RequestBody @Valid Pedido pedido){
		
		Pedido pedidoSalvo = service.salvar(pedido);
		
		URI location = montarLocation(pedidoSalvo);

		return ResponseEntity.created(location).build();
	}
	
	@PostMapping(RotasV1.CALCULAR_TOTAIS)
	public ResponseEntity<Object> calcularTotais(@RequestBody @Valid Pedido pedido){
		
		pedido.prepararParaSalvar();
		return ResponseEntity.ok(pedido);
	}

	@PutMapping
	public void atualizar(@RequestBody @Valid Pedido pedido){
		service.salvar(pedido);
	}
	
	private URI montarLocation(Pedido pedido) {
		return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path(RotasV1.ID)
                .buildAndExpand(pedido.getId())
                .toUri();
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    return ex.getBindingResult()
	    		 .getAllErrors().stream()
	    		 .map(ObjectError::getDefaultMessage)
	    		 .collect(Collectors.toList());
	}
}