package com.mindtree.ShoppingCart.dao.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ShoppingCart.dao.UserDao;
import com.mindtree.ShoppingCart.entity.User;
import com.mindtree.ShoppingCart.repository.UserRepository;

/**
 * @author M1056333
 *
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
	public User addUser(User user) {
		logger.info("Add User to repo");
		 return userRepository.save(user);
		
	}
	
	public boolean isPresent(int userId) {
		logger.info("Checking User is Present in repo...!");
		return userRepository.existsById(userId);
	}

	@Override
	public User fetchUser(int userId) {
		logger.info("Fetching User from Repo..!");
		return userRepository.findById(userId).get();
	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = false)
	public void updateUser(User user) {
		logger.info("Update and saving User in repo");
		userRepository.saveAndFlush(user);
	}

}
