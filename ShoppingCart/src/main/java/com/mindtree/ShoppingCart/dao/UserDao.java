package com.mindtree.ShoppingCart.dao;

import com.mindtree.ShoppingCart.entity.User;

/**
 * @author M1056333
 *
 */
public interface UserDao {
	
	User addUser(User user);
	
	boolean isPresent(int userId);

	User fetchUser(int userId);

	void updateUser(User user);
}
