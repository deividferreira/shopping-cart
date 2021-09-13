package com.github.deividferreira.shoppingcart.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.deividferreira.shoppingcart.dto.cupons.CupomCreate;
import com.github.deividferreira.shoppingcart.dto.cupons.CupomDTO;
import com.github.deividferreira.shoppingcart.services.CupomService;

@Controller
@RequestMapping(value = "/cupons")
public class CupomController {

	private final CupomService service;

	public CupomController(CupomService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<CupomDTO>> findAll() {
		return ResponseEntity.ok().body(service.listarTodos().stream()
				.map(CupomDTO::toDTO).collect(Collectors.toList()));
	}

	@PostMapping
	public ResponseEntity<CupomDTO> create(@RequestBody CupomCreate cupom) {

		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CupomDTO.toDTO(service.create(cupom.toEntity())));
	}

}
