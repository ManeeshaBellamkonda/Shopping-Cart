package com.mindtree.ShoppingCart.service;

import com.mindtree.ShoppingCart.entity.User;
import com.mindtree.ShoppingCart.exception.ShoppingCartServiceException;

/**
 * @author M1056333
 *
 */
public interface UserService {

	User addUser(User user);
	
	public User fetchUser(int userId) throws ShoppingCartServiceException;
	
	public void updateUser(User user);

}
