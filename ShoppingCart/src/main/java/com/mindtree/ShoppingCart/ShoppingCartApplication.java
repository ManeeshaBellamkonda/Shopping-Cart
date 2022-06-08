package com.mindtree.ShoppingCart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableTransactionManagement
public class ShoppingCartApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartApplication.class);

	public static void main(String[] args) {
		logger.info(" Shopping Cart Application Started SuccessFully......!");
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
