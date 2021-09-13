package com.github.deividferreira.shoppingcart.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.deividferreira.shoppingcart.entities.Carrinho;
import com.github.deividferreira.shoppingcart.entities.ItemCarrinho;
import com.github.deividferreira.shoppingcart.entities.Produto;
import com.github.deividferreira.shoppingcart.repositories.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProdutoService {

	private final ProdutoRepository repository;
	private final CarrinhoService carrinhoService;

	public List<Produto> listarTodos() {
		return repository.findAll();
	}

	@Transactional
	public Produto create(Produto entity) {
		return repository.save(entity);
	}

	@Transactional
	public Carrinho adicionarNoCarrinho(Long idProduto) {
		return carrinhoService
				.addItem(new ItemCarrinho(new Produto(idProduto)));
	}

}
