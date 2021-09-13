package com.github.deividferreira.shoppingcart.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.deividferreira.shoppingcart.dto.carrinho.CarrinhoDTO;
import com.github.deividferreira.shoppingcart.dto.produtos.ProdutoCreate;
import com.github.deividferreira.shoppingcart.dto.produtos.ProdutoDTO;
import com.github.deividferreira.shoppingcart.services.ProdutoService;

@Controller
@RequestMapping(value = "/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		return ResponseEntity.ok().body(produtoService.listarTodos().stream()
				.map(ProdutoDTO::toDTO).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(
			@RequestBody ProdutoCreate produto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(
				ProdutoDTO.toDTO(produtoService.create(produto.toEntity())));
	}
	
	@PutMapping(value = "/{id}/adicionar-carrinho")
	public ResponseEntity<CarrinhoDTO> adicionarNoCarrinho(
			@PathVariable Long id) {

		return ResponseEntity.ok().body(
				CarrinhoDTO.toDTO(produtoService.adicionarNoCarrinho(id)));
	}

}
