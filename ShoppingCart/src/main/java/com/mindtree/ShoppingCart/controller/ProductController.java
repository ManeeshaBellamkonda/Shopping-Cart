package com.mindtree.ShoppingCart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ShoppingCart.entity.Product;
import com.mindtree.ShoppingCart.exception.ShoppingCartException;
import com.mindtree.ShoppingCart.service.ProductService;

/**
 * @author M1056333
 *
 */
@RestController
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductController {
	@Autowired
	ProductService productService;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping(value = "/product/search-by-id/{productId}")
	public Product searchById(@PathVariable int productId) throws ShoppingCartException {
		logger.info("Searching Product by Id..!");
		Product product = productService.searchById(productId);
		return product;
	}

	@GetMapping(value = "/product/search-by-name/{productName}")
	public Product searchByName(@PathVariable String productName) throws ShoppingCartException {
		logger.info("Searching Product By Name..!");
		Product product = productService.searchByName(productName);
		return product;
	}

	@GetMapping(value = "/product/search-by-category/{productCategory}")
	public List<Product> searchByCategory(@PathVariable String productCategory) throws ShoppingCartException {
		logger.info("Searching Product By Category..!");
		List<Product> productList = productService.searchByCategory(productCategory);
		return productList;
	}
}
