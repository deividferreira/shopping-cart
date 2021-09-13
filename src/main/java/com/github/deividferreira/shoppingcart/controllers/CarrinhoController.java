package com.github.deividferreira.shoppingcart.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.deividferreira.shoppingcart.dto.carrinho.CarrinhoDTO;
import com.github.deividferreira.shoppingcart.dto.carrinho.ItemCarrinhoCreate;
import com.github.deividferreira.shoppingcart.services.CarrinhoService;

@Controller
@RequestMapping(value = "/carrinho")
public class CarrinhoController {

	private final CarrinhoService service;

	public CarrinhoController(CarrinhoService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<CarrinhoDTO> getCarrinho() {
		return ResponseEntity.ok().body(
				CarrinhoDTO.toDTO(service.buscarCarrinho()));
	}
	
	@PostMapping
	public ResponseEntity<CarrinhoDTO> addItemCarrinho(
			@RequestBody ItemCarrinhoCreate item) {

		return ResponseEntity.ok()
				.body(CarrinhoDTO.toDTO(service.addItem(item.toEntity())));
	}
	
	@PutMapping("/aplicar-cupom/{idCupom}")
	public ResponseEntity<CarrinhoDTO> aplicarCupomDesconto(
			@PathVariable Long idCupom) {
		
		return ResponseEntity.ok()
				.body(CarrinhoDTO.toDTO(service.aplicarCupomDesconto(idCupom)));
	}

}
