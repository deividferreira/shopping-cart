package com.github.deividferreira.shoppingcart.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.github.deividferreira.shoppingcart.entities.enums.DescontoProgressivo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@AllArgsConstructor
@Table(name = "carrinho")
public class Carrinho {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	@ManyToOne
	private Cupom cupom;
	@Getter
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "carrinho")
	private List<ItemCarrinho> itens;

	public Carrinho() {
		this.itens = new ArrayList<>();
	}

	/**
	 * @return Total do carrinho, sem qualquer tipo de desconto.
	 */
	public BigDecimal getSubtotal() {
		return this.itens.stream().map(ItemCarrinho::getSubtotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	public BigDecimal getTotal() {
		BigDecimal subTotal = getSubtotal();
		BigDecimal valorTotalDeItensComDescontoAcima10Pecas = getTotalItensComDesconto();
		BigDecimal valorComDescontoProgressivo = DescontoProgressivo
				.getInstance(subTotal)
				.aplicar(valorTotalDeItensComDescontoAcima10Pecas);

		return aplicarCupomDesconto(valorComDescontoProgressivo);
	}

	/**
	 * @return total dos itens do carrinho aplicado desconto caso exista mais de
	 *         10 itens do mesmo
	 */
	private BigDecimal getTotalItensComDesconto() {
		return this.itens.stream().map(ItemCarrinho::getTotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal aplicarCupomDesconto(BigDecimal total) {
		if (Objects.nonNull(this.cupom)) {
			return total.subtract(this.cupom.getValor());
		} else {
			return total;
		}
	}

	public void addItem(ItemCarrinho itemCarrinho) {
		Optional<ItemCarrinho> itemExisteCarrinho = this.itens.stream().filter(
				item -> item.getProduto().equals(itemCarrinho.getProduto()))
				.findFirst();

		itemExisteCarrinho.ifPresentOrElse(item -> {
			item.adicionarMaisUm();
		}, () -> {
			itemCarrinho.setCarrinho(this);
			this.itens.add(itemCarrinho);
		});
	}

	public void addCupomDesconto(Cupom cupom) {
		if (Objects.nonNull(this.cupom)) {
			if (this.cupom.getValor().compareTo(cupom.getValor()) <= 0) {
				this.cupom = cupom;
			}
		} else {
			this.cupom = cupom;
		}
	}

}
