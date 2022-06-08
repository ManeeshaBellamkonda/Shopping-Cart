package com.mindtree.ShoppingCart.service;

import java.util.List;

import com.mindtree.ShoppingCart.entity.Product;
import com.mindtree.ShoppingCart.exception.ShoppingCartServiceException;

public interface ProductService {
	
	Product searchById(int productId) throws ShoppingCartServiceException ;

	Product searchByName(String productName) throws ShoppingCartServiceException;

	List<Product> searchByCategory(String productCategory) throws ShoppingCartServiceException;
	
	Product fetchProduct(int productId) throws ShoppingCartServiceException;
	
	public void updateProduct(Product product);
	
	Product saveProduct(Product product);
	

}
