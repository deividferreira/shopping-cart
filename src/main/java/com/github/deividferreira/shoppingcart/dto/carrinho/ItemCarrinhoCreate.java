package com.github.deividferreira.shoppingcart.dto.carrinho;

import com.github.deividferreira.shoppingcart.entities.ItemCarrinho;
import com.github.deividferreira.shoppingcart.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemCarrinhoCreate {

	private Long idProduto;
	private Integer quantidade;

	public ItemCarrinho toEntity() {
		return new ItemCarrinho(new Produto(idProduto), quantidade);
	}

}
