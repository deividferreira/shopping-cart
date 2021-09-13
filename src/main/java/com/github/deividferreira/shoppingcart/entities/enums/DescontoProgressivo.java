package com.github.deividferreira.shoppingcart.entities.enums;

import java.math.BigDecimal;

import com.github.deividferreira.shoppingcart.utils.DescontoUtils;

public enum DescontoProgressivo {

	ZERO(0, BigDecimal.ZERO) {
		@Override
		public BigDecimal aplicar(BigDecimal valorTotal) {
			return valorTotal;
		}
	},
	CINCO(5, BigDecimal.valueOf(1000)) {
		@Override
		public BigDecimal aplicar(BigDecimal valorTotal) {
			
			return DescontoUtils.aplicar(this.getDesconto(), valorTotal);
		}
	},

	SETE(7, BigDecimal.valueOf(5000)) {
		@Override
		public BigDecimal aplicar(BigDecimal valorTotal) {
			
			return DescontoUtils.aplicar(this.getDesconto(), valorTotal);
		}
	},

	DEZ(10, BigDecimal.valueOf(10000)) {
		@Override
		public BigDecimal aplicar(BigDecimal valorTotal) {

			return DescontoUtils.aplicar(this.getDesconto(), valorTotal);
		}
	};

	private final Integer desconto;
	private final BigDecimal valor;

	DescontoProgressivo(Integer desconto, BigDecimal valor) {
		this.desconto = desconto;
		this.valor = valor;
	}

	public static DescontoProgressivo build(BigDecimal valorTotal) {
		if (valorTotal.compareTo(CINCO.valor) >= 0
				&& valorTotal.compareTo(SETE.valor) < 0) {

			return CINCO;
		} else if (valorTotal.compareTo(SETE.valor) >= 0
				&& valorTotal.compareTo(DEZ.valor) < 0) {

			return SETE;
		} else if (valorTotal.compareTo(DEZ.valor) >= 0) {
			return DEZ;
		} else {
			return ZERO;
		}
	}

	public abstract BigDecimal aplicar(BigDecimal valorTotal);

	public Integer getDesconto() {
		return this.desconto;
	}

}
