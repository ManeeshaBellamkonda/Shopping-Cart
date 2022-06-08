/**
 * 
 */
package com.mindtree.ShoppingCart.dao;

import java.util.List;

import com.mindtree.ShoppingCart.entity.Apparel;
import com.mindtree.ShoppingCart.entity.Book;
import com.mindtree.ShoppingCart.entity.Product;
import com.mindtree.ShoppingCart.exception.ShoppingCartDaoException;

/**
 * @author M1056333
 *
 */
public interface ProductDao {
	Product searchById(int productId) throws ShoppingCartDaoException;

	Product searchByName(String productName) throws ShoppingCartDaoException;

	List<Book> findAllByBook() throws ShoppingCartDaoException;

	List<Apparel> findAllByApparel() throws ShoppingCartDaoException;
	
	List<Product> getAllProduct(Product product);
	
	boolean checkProduct(int productId);
	
	void updateProduct(Product product);
	
	Product saveProduct(Product product);


}
