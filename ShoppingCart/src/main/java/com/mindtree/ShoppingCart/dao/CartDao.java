package com.mindtree.ShoppingCart.dao;

import com.mindtree.ShoppingCart.entity.Cart;

public interface CartDao {
	
	void createCart(Cart cart);

	Cart fetchCart(int cartId);

	void updateCart(Cart cart);

	void deleteCart(int cartId);

}
