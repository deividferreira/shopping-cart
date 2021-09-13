package com.github.deividferreira.shoppingcart.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.deividferreira.shoppingcart.entities.Carrinho;
import com.github.deividferreira.shoppingcart.entities.Cupom;
import com.github.deividferreira.shoppingcart.entities.ItemCarrinho;
import com.github.deividferreira.shoppingcart.entities.Produto;
import com.github.deividferreira.shoppingcart.exceptions.BusinessException;
import com.github.deividferreira.shoppingcart.repositories.CarrinhoRepository;
import com.github.deividferreira.shoppingcart.repositories.CupomRepository;
import com.github.deividferreira.shoppingcart.repositories.ProdutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CarrinhoService {

	private final CarrinhoRepository repository;
	private final ProdutoRepository produtoRepository;
	private final CupomRepository cupomRepository;

	@Transactional
	public Carrinho addItem(ItemCarrinho item) {
		Produto produto = produtoRepository.findById(item.getProduto().getId())
				.orElseThrow(
						() -> new BusinessException("Produto não encontrado"));

		item = new ItemCarrinho(produto, item.getQuantidade());

		Carrinho carrinho = repository.findFirstByOrderByIdDesc()
				.orElse(new Carrinho());

		carrinho.addItem(item);

		return this.repository.save(carrinho);
	}

	public Optional<Carrinho> buscarCarrinho() {
		return this.repository.findFirstByOrderByIdDesc();
	}

	public Carrinho aplicarCupomDesconto(Long idCupom) {
		Cupom cupom = cupomRepository.findById(idCupom).orElseThrow(
				() -> new BusinessException("Cupom não encontrado"));
		
		Carrinho carrinho = repository.findFirstByOrderByIdDesc()
				.orElseThrow(() -> new BusinessException(
						"Nenhum carrinho encontrado para aplicar cupom de desconto"));

		carrinho.addCupomDesconto(cupom);

		return this.repository.save(carrinho);
	}

}
