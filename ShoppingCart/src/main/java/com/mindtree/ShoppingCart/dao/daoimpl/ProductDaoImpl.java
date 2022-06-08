package com.mindtree.ShoppingCart.dao.daoimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.ShoppingCart.dao.ProductDao;
import com.mindtree.ShoppingCart.entity.Apparel;
import com.mindtree.ShoppingCart.entity.Book;
import com.mindtree.ShoppingCart.entity.Product;
import com.mindtree.ShoppingCart.exception.ProductNotFoundException;
import com.mindtree.ShoppingCart.exception.ShoppingCartDaoException;
import com.mindtree.ShoppingCart.repository.ApparelRepository;
import com.mindtree.ShoppingCart.repository.BookRepository;
import com.mindtree.ShoppingCart.repository.ProductRepository;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductDaoImpl implements ProductDao {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	BookRepository bookRepository;

	@Autowired
	ApparelRepository apparelRepository;

	private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

	@Override
	public Product searchById(int productId) throws ShoppingCartDaoException {
		logger.info("SearchBy Id in impl");
		if (!(productRepository.findById(productId).isPresent())) {
			logger.error("Exception due to product not found in DB");
			throw new ProductNotFoundException("Product ID Not Found");
		} else {
			logger.info("Returning Product for the entered productId");
			Product productResult = productRepository.findById(productId).get();
			return productResult;
		}
	}

	@Override
	public Product searchByName(String productName) throws ShoppingCartDaoException {
		logger.info("SearchBy Name in impl");
		if ((productRepository.existsByProductName(productName)) == true) {
			logger.info("Returning Product for the entered productName");
			Product productResult = productRepository.findByProductName(productName);
			return productResult;
		} else {
			logger.error("Exception due to  product not found in DB");
			throw new ProductNotFoundException("Product Name Not Found");
		}
	}

	@Override
	public List<Book> findAllByBook() throws ShoppingCartDaoException {
		logger.info("Fetching list of Books from repository..!");
		if (bookRepository.findAll().isEmpty()) {
			logger.error("Exception due to No Books Available in DB");
			throw new ProductNotFoundException("No Product for Book is available");
		} else {
			logger.info("Returning books from repo");
			List<Book> bookListResult = bookRepository.findAll();
			return bookListResult;
		}
	}

	@Override
	public List<Apparel> findAllByApparel() throws ShoppingCartDaoException {
		logger.info("Fetching list of Apparels from repository..!");
		if (apparelRepository.findAll().isEmpty()) {
			logger.error("Exception due to No Apparel Available in DB");
			throw new ProductNotFoundException("No Product for Apparel is available");
		} else {
			logger.info("Returning apparels from repo");
			List<Apparel> apparelListResult = apparelRepository.findAll();
			return apparelListResult;
		}
	}

	@Override
	public List<Product> getAllProduct(Product product) {
		logger.info("Fetching all products from repo..!");
		List<Product> productList = productRepository.findAll();
		return productList;
	}

	@Override
	public boolean checkProduct(int productId) {
		logger.info("Check product presence By Id..!");
		return productRepository.existsById(productId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void updateProduct(Product product) {
		logger.info("Updating product in repo..!");
		productRepository.saveAndFlush(product);

	}

	@Override
	public Product saveProduct(Product product) {
		logger.info("Save all the products in repo..!");
		return productRepository.save(product);
	}

}
