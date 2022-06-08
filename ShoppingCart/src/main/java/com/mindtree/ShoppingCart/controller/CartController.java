package com.mindtree.ShoppingCart.controller;

import org.omg.CORBA.portable.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ShoppingCart.entity.Cart;
import com.mindtree.ShoppingCart.exception.ShoppingCartException;
import com.mindtree.ShoppingCart.service.CartService;

/**
 * @author M1056333
 *
 */
@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@PostMapping(value = "/cart/add-product/{userId}/{productId}")
	public Cart addProductsToCart(@PathVariable int userId, @PathVariable int productId) throws ShoppingCartException {
		logger.info("Adding Items into Cart...!");
		Cart cart = cartService.addProductsToCart(userId, productId);
		return cart;
	}

	@GetMapping(value = "cart/view-cart/{userId}")
	public Cart viewCart(@PathVariable int userId) throws ShoppingCartException {
		logger.info("View Items present in a cart...!");
		Cart cart = cartService.viewCart(userId);
		return cart;
	}

	@DeleteMapping(value = "/cart/delete-single-product/{userId}/{productId}")
	public Cart deleteAProductFromCart(@PathVariable int userId, @PathVariable int productId)
			throws ShoppingCartException {
		logger.info("Delete particular items from cart...!");
		Cart cart = cartService.deleteProductFromCart(userId, productId);
		return cart;
	}

	@DeleteMapping(value = "/cart/delete-all-product/{userId}")
	public String deleteAllProductFromCart(@PathVariable int userId) throws ShoppingCartException {
		logger.info("Delete all items from cart...!");
		String cart = cartService.deleteAllProductFromCart(userId);
		return cart;
	}

	@PutMapping(value = "/cart/update-product-quantity/{userId}/{productId}/{productQuantity}")
	public Cart updateProductQuantity(@PathVariable int userId, @PathVariable int productId,
			@PathVariable int productQuantity) throws ApplicationException, ShoppingCartException {
		logger.info("Update product quantity for particular userId and productId...!");
		Cart cart = cartService.updateProductQuantity(userId, productId, productQuantity);
		return cart;
	}
}
