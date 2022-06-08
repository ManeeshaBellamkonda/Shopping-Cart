package com.mindtree.ShoppingCart.service.serviceimpl;

import java.util.ArrayList;
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
import com.mindtree.ShoppingCart.exception.ShoppingCartServiceException;
import com.mindtree.ShoppingCart.service.ProductService;

/**
 * @author M1056333
 *
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Override
	public Product searchById(int productId) throws ShoppingCartServiceException {
		logger.info("Search by Id in repo..!");
		if(!productDao.checkProduct(productId)) {
			logger.error("Product Not Found Exception Found..!");
			throw new ProductNotFoundException("Product Not Found");
		}
		Product productResult=productDao.searchById(productId);
		return productResult;
	}

	@Override
	public Product searchByName(String productName) throws ShoppingCartServiceException {
		logger.info("Search by Name in impl");
		Product productResult=productDao.searchByName(productName);
		return productResult;
	}

	@Override
	public List<Product> searchByCategory(String productCategory) throws ShoppingCartServiceException {
		logger.info("Search by Category in repo...!");
		List<Product> productResult=new ArrayList<Product>();
		if(productCategory.equalsIgnoreCase("Book"))
		{
			logger.info("Seaching Book category...!");
			List<Book> bookListResult=productDao.findAllByBook();
			if( bookListResult.size()==0) {
				logger.error("Book category Not Found..!");
				throw new ProductNotFoundException("Product Category Doesn't Exist");
			}
			bookListResult.stream().forEach(book->productResult.add(book));	
		}
		else if(productCategory.equalsIgnoreCase("Apparel"))
		{
			logger.info("Seaching Apparel category...!");
			List<Apparel> apparelListResult=productDao.findAllByApparel();
			if(apparelListResult.size()==0) {
				logger.error("Apparel category Not Found..!");
				throw new ProductNotFoundException("Product Category Doesn't Exist");
			}
			apparelListResult.stream().forEach(apparel->productResult.add(apparel));
		}
		else
		{
			logger.error("Product Category Not Found..!");
			throw new ProductNotFoundException("Product Category Doesn't Exist");
		}
		return productResult;
	}

	@Override
	public Product fetchProduct(int productId) throws ShoppingCartServiceException {
		logger.info("Fetching a Product from repo..!");
		if(!productDao.checkProduct(productId)) {
			logger.error("Product Category Not Found..!");
			throw new ProductNotFoundException("Product Not Found");
		}
		return productDao.searchById(productId);
	}

	@Override
	public void updateProduct(Product product) {
		logger.info("Updating a Product in repo..!");
		productDao.updateProduct(product);
		
	}

	@Override
	public Product saveProduct(Product product) {
		logger.info("Savinging a Product in repo..!");
		return productDao.saveProduct(product);
	}
}
		
	

