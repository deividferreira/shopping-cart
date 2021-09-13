package com.github.deividferreira.shoppingcart.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.deividferreira.shoppingcart.entities.Cupom;
import com.github.deividferreira.shoppingcart.repositories.CupomRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CupomService {

	private final CupomRepository repository;

	public List<Cupom> listarTodos() {
		return repository.findAll();
	}

	@Transactional
	public Cupom create(Cupom entity) {
		return repository.save(entity);
	}

}
