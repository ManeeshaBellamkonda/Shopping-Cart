/**
 * 
 */
package com.mindtree.ShoppingCart.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ShoppingCart.entity.User;
import com.mindtree.ShoppingCart.service.UserService;

/**
 * @author M1056333
 *
 */
@RestController
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserController {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@PostMapping(value = "/add-User")
	public User addUser(@RequestBody User user) {
		logger.info("Add User to database...!");
		return userService.addUser(user);
		
	}

}
