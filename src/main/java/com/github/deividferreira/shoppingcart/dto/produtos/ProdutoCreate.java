package com.github.deividferreira.shoppingcart.dto.produtos;

import java.math.BigDecimal;

import com.github.deividferreira.shoppingcart.entities.Produto;
import com.github.deividferreira.shoppingcart.entities.enums.TipoProduto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProdutoCreate {

	private String nome;
	private BigDecimal valor;
	private TipoProduto tipo;

	public Produto toEntity() {
		return new Produto(null, nome, valor, tipo);
	}

}
