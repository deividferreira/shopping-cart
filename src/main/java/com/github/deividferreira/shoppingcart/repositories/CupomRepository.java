package com.github.deividferreira.shoppingcart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.deividferreira.shoppingcart.entities.Cupom;

@Repository
public interface CupomRepository extends JpaRepository<Cupom, Long> {

}
