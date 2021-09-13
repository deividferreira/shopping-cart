package com.github.deividferreira.shoppingcart.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.github.deividferreira.shoppingcart.utils.DescontoUtils;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "itens")
@EqualsAndHashCode(of = {"produto"})
public class ItemCarrinho {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@OneToOne
	private Produto produto;
	@Getter
	@Setter
	@ManyToOne
	private Carrinho carrinho;
	@Getter
	private Integer quantidade;

	public ItemCarrinho(Produto produto) {
		this.produto = produto;
		this.quantidade = 1;
	}

	public ItemCarrinho(Produto produto, Integer quantidade) {
		this(produto);
		this.quantidade = quantidade;
	}

	public void adicionarMaisUm() {
		this.quantidade += 1;
	}

	public BigDecimal getSubtotal() {
		return BigDecimal.valueOf(this.quantidade)
				.multiply(this.produto.getValor());
	}

	public BigDecimal getTotal() {
		if (this.quantidade >= 10) {
			return DescontoUtils.aplicar(10, getSubtotal());
		} else {
			return getSubtotal();
		}
	}

}
