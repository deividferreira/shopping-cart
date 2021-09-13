package com.github.deividferreira.shoppingcart.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.github.deividferreira.shoppingcart.entities.enums.TipoProduto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Produto {

	@Id
	@Getter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Getter
	private String nome;
	@Getter
	private BigDecimal valor;
	@Getter
	@Enumerated(EnumType.STRING)
	private TipoProduto tipo;

	public Produto(Long id) {
		this.id = id;
	}
}
