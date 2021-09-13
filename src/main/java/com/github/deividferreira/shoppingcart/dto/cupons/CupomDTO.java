package com.github.deividferreira.shoppingcart.dto.cupons;

import java.math.BigDecimal;

import com.github.deividferreira.shoppingcart.entities.Cupom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CupomDTO {

	private Long id;
	private BigDecimal valor;

	public static CupomDTO toDTO(Cupom cupom) {
		return new CupomDTO(cupom.getId(), cupom.getValor());
	}

}
