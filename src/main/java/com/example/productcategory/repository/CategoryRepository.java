package com.example.productcategory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.productcategory.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
           @Query("Select C from Category C ORDER BY C.Cid ASC")
           List<Category> findAll();

}
