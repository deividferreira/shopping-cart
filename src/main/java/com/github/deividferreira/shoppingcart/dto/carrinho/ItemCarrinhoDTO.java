package com.github.deividferreira.shoppingcart.dto.carrinho;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.github.deividferreira.shoppingcart.dto.produtos.ProdutoDTO;
import com.github.deividferreira.shoppingcart.entities.ItemCarrinho;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemCarrinhoDTO {

	private Long id;
	private ProdutoDTO produto;
	private Integer quantidade;
	private BigDecimal totalPorItem;
	private BigDecimal subTotalPorItem;

	public static ItemCarrinhoDTO toDTO(ItemCarrinho item) {
		return new ItemCarrinhoDTO(item.getId(),
				ProdutoDTO.toDTO(item.getProduto()), item.getQuantidade(),
				item.getTotal(), item.getSubtotal());
	}

	public static List<ItemCarrinhoDTO> toDTO(List<ItemCarrinho> itens) {
		return itens.stream().map(ItemCarrinhoDTO::toDTO)
				.collect(Collectors.toList());
	}
}
