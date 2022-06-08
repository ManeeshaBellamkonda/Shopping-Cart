/**
 * 
 */
package com.mindtree.ShoppingCart.service.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ShoppingCart.dao.UserDao;
import com.mindtree.ShoppingCart.entity.User;
import com.mindtree.ShoppingCart.exception.ShoppingCartServiceException;
import com.mindtree.ShoppingCart.exception.UserNotFoundException;
import com.mindtree.ShoppingCart.service.UserService;

/**
 * @author M1056333
 *
 */
@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User addUser(User user) {
		logger.info(" User Registered into DB..!");
		return userDao.addUser(user);
	}

	@Override
	public User fetchUser(int userId) throws ShoppingCartServiceException {
		logger.info("Fetching user from repo..!");
		if(!userDao.isPresent(userId))
		{
			logger.error("User Not Found..!");
			throw new UserNotFoundException("User Not Found");
		}
		return userDao.fetchUser(userId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateUser(User user) {
		logger.info("Saving user in repo..!");
		userDao.updateUser(user);
		
	}

}
