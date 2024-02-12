package com.example.productcategory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productcategory.model.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("select P from Product P ORDER BY P.poductId ASC")
	List<Product>findAll();
}
