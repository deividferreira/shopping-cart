package com.github.deividferreira.shoppingcart.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.deividferreira.shoppingcart.entities.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

	Optional<Carrinho> findFirstByOrderByIdDesc();

}
