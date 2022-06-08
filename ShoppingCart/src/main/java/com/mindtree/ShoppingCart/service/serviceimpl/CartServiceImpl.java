package com.mindtree.ShoppingCart.service.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ShoppingCart.dao.CartDao;
import com.mindtree.ShoppingCart.entity.Cart;
import com.mindtree.ShoppingCart.entity.Product;
import com.mindtree.ShoppingCart.entity.User;
import com.mindtree.ShoppingCart.exception.CartNotFoundException;
import com.mindtree.ShoppingCart.exception.ProductNotFoundException;
import com.mindtree.ShoppingCart.exception.ShoppingCartServiceException;
import com.mindtree.ShoppingCart.exception.UnableToDeleteException;
import com.mindtree.ShoppingCart.exception.UserNotFoundException;
import com.mindtree.ShoppingCart.service.CartService;
import com.mindtree.ShoppingCart.service.ProductService;
import com.mindtree.ShoppingCart.service.UserService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CartServiceImpl implements CartService {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartDao cartDao;

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Cart addProductsToCart(int userId, int productId) throws ShoppingCartServiceException {
		logger.info("Adding products to cart");
		Product product = productService.fetchProduct(productId);
		Cart cart;
		User user = userService.fetchUser(userId);
		if (!((product.getCart() == null) || (user.getCart() == product.getCart()))) {
			logger.error("Product not available...!");
			throw new ProductNotFoundException("Product Not Available");
		}

		if (user.getCart() == null) {
			logger.info("Create new cart for user...!");
			cart = new Cart();
			user.setCart(cart);
			cart.setCartPrice(cart.getCartPrice() + (double) product.getPrice());
			cartDao.createCart(cart);
			product.setCart(cart);
			product.setQuantity(1);
			productService.updateProduct(product);
		}

		else {
			logger.info("If cart is present product added to cart...!");
			cart = cartDao.fetchCart(user.getCart().getCartId());
			cart.setCartPrice(cart.getCartPrice() + (double) product.getPrice());
			cartDao.updateCart(cart);
			product.setQuantity(product.getQuantity() + 1);
			product.setCart(cart);
			productService.updateProduct(product);
		}
		return cart;

	}

	@Override
	public Cart viewCart(int userId) throws ShoppingCartServiceException {
		logger.info("View items in cart...!");
		User user = userService.fetchUser(userId);
		Cart cart = user.getCart();
		return cart;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Cart deleteProductFromCart(int userId, int productId) throws ShoppingCartServiceException {
		logger.info("Delete product from user cart...!");
		User user = userService.fetchUser(userId);
		Cart cart = cartDao.fetchCart(user.getCart().getCartId());
		Product product = productService.fetchProduct(productId);
		if (cart == null) {
			logger.error("Cart not available for associated user...!");
			throw new CartNotFoundException(
					"Product not found for the entered user as no cart is associated with the user");
		}
		if ((product.getCart() == null) || (product.getCart().getCartId() != cart.getCartId())) {
			logger.error("Product not available for associated user...!");
			throw new ProductNotFoundException("Product Not Found for the entered user");
		}
		double priceProduct = (double) product.getQuantity() * product.getPrice();
		cart.setCartPrice(cart.getCartPrice() - priceProduct);
		cartDao.updateCart(cart);
		product.setCart(null);
		product.setQuantity(0);
		productService.updateProduct(product);
		productService.saveProduct(product);
		return cart;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public String deleteAllProductFromCart(int userId) throws ShoppingCartServiceException {
		logger.info("Deleting All the product for the User");
		User user = userService.fetchUser(userId);
		int cartId = user.getCart().getCartId();
		Cart cart = user.getCart();
		if(user.getUserId()!=userId)
		{
			logger.error("Exception of User not found");
			throw new UserNotFoundException("User not found");
		}

		if(cart==null)
		{
			logger.error("Exception of Cart being null for the given user");
			throw new CartNotFoundException("Cart was already empty for user as the cart was not assigned to the user");
		}
		
		List<Product> productList = cart.getProductList();
		for (Product product : productList) {
			product.setCart(null);
			product.setQuantity(0);
			productService.saveProduct(product);
		}
		cart.setCartPrice(0);
		user.setCart(null);
		userService.updateUser(user);
		cartDao.deleteCart(cartId);
		return "Successfully deleted";
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Cart updateProductQuantity(int userId, int productId, int productQuantity)
			throws ShoppingCartServiceException {
		logger.info("Update cart in impl..!");
		User user = userService.fetchUser(userId);
		double value;
		Cart cart = cartDao.fetchCart(user.getCart().getCartId());
		int cartId = user.getCart().getCartId();
		Product product = productService.fetchProduct(productId);
		if (!(product.getCart().getCartId() == cart.getCartId())) {
			logger.error("Product does not belong to user..!");
			throw new ProductNotFoundException("Product Not Found");
		}
		if (productQuantity == 0) {
			value = product.getQuantity() * product.getPrice();
			cart.setCartPrice(cart.getCartPrice() - value);
			product.setCart(null);
			product.setQuantity(0);
			productService.updateProduct(product);
		} else {
			value = (double) product.getPrice() * productQuantity;
			cart.setCartPrice(cart.getCartPrice() + (value));

			product.setQuantity(product.getQuantity() + (productQuantity));
			if (product.getQuantity() == 0) {
				product.setCart(null);
			}
			if (product.getQuantity() < 0) {
				logger.error("Unable to update the quantity to lower limit..!");
				throw new UnableToDeleteException("Updation Upto Quantity 1 is Allowed as a lower limit");
			}
			productService.updateProduct(product);
		}
		if (cart.getCartPrice() == 0) {
			user.setCart(null);
			userService.updateUser(user);
			cart.setProductList(null);
			cartDao.deleteCart(cartId);
		}
		return cart;
	}

}
