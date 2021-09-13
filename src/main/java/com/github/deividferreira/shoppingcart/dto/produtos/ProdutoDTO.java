package com.github.deividferreira.shoppingcart.dto.produtos;

import java.math.BigDecimal;

import com.github.deividferreira.shoppingcart.entities.Produto;
import com.github.deividferreira.shoppingcart.entities.enums.TipoProduto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProdutoDTO {

	private Long id;
	private String nome;
	private BigDecimal valor;
	private TipoProduto tipo;

	public static ProdutoDTO toDTO(Produto produto) {
		return new ProdutoDTO(produto.getId(), produto.getNome(),
				produto.getValor(), produto.getTipo());
	}

}
