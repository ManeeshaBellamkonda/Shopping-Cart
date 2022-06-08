package com.mindtree.ShoppingCart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.ShoppingCart.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
