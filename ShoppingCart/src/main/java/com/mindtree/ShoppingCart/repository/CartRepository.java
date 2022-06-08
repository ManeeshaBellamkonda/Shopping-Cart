package com.mindtree.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.ShoppingCart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	

}
