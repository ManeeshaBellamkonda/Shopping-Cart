package com.mindtree.ShoppingCart.dao.daoimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ShoppingCart.dao.CartDao;
import com.mindtree.ShoppingCart.entity.Cart;
import com.mindtree.ShoppingCart.repository.CartRepository;

@Service
public class CartDaoImpl implements CartDao {

	@Autowired
	private CartRepository cartRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(CartDaoImpl.class);

	@Override
	public void createCart(Cart cart) {
		logger.info("Creating a cart in repo..>!");
		cartRepository.save(cart);
	}

	@Override
	public Cart fetchCart(int cartId) {
		logger.info("Fetching a cartId ..!");
		return cartRepository.findById(cartId).get();
	}

	@Override
	public void updateCart(Cart cart) {
		logger.info("Updating a cart..!");
		cartRepository.saveAndFlush(cart);
	}

	@Override
	public void deleteCart(int cartId) {
		logger.info("Delete a cart By id...!");
		cartRepository.deleteById(cartId);
	}

}
