package com.github.deividferreira.shoppingcart.dto.carrinho;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.github.deividferreira.shoppingcart.entities.Carrinho;
import com.github.deividferreira.shoppingcart.entities.Cupom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CarrinhoDTO {

	private Long id;
	private Cupom cupomDesconto;
	private List<ItemCarrinhoDTO> itens;
	private BigDecimal total;
	private BigDecimal subtotal;

	public static CarrinhoDTO toDTO(Optional<Carrinho> possivelCarrinho) {
		if (possivelCarrinho.isPresent()) {
			final Carrinho carrinho = possivelCarrinho.get();

			return toDTO(carrinho);
		} else {
			return null;
		}
	}

	public static CarrinhoDTO toDTO(Carrinho carrinho) {
		return new CarrinhoDTO(carrinho.getId(), carrinho.getCupom(),
				ItemCarrinhoDTO.toDTO(carrinho.getItens()), carrinho.getTotal(),
				carrinho.getSubtotal());
	}

}
