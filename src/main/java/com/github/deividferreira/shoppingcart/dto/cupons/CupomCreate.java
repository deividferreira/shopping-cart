package com.github.deividferreira.shoppingcart.dto.cupons;

import java.math.BigDecimal;

import com.github.deividferreira.shoppingcart.entities.Cupom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CupomCreate {

	private BigDecimal valor;

	public Cupom toEntity() {
		return new Cupom(null, valor);
	}

}
