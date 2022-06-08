package com.mindtree.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.ShoppingCart.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
