package com.github.deividferreira.shoppingcart.utils;

import java.math.BigDecimal;

public interface DescontoUtils {

	public static BigDecimal aplicar(Integer percentual, BigDecimal valor) {
		BigDecimal percentualDesconto = BigDecimal.valueOf(percentual).divide(new BigDecimal(100));
		BigDecimal desconto = valor.multiply(percentualDesconto);

		return valor.subtract(desconto);
	}

}
