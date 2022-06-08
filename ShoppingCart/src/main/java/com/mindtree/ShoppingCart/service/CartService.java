package com.mindtree.ShoppingCart.service;

import com.mindtree.ShoppingCart.entity.Cart;
import com.mindtree.ShoppingCart.exception.ShoppingCartServiceException;

public interface CartService {
	
	public Cart addProductsToCart(int userId, int productId) throws ShoppingCartServiceException;
	
	public Cart viewCart(int userId) throws ShoppingCartServiceException;
	
	public Cart deleteProductFromCart(int userId, int productId) throws ShoppingCartServiceException;
	
	public String deleteAllProductFromCart(int userId) throws ShoppingCartServiceException;
	
	public Cart updateProductQuantity(int userId, int productId, int productQuantity) throws ShoppingCartServiceException ;
	

}
