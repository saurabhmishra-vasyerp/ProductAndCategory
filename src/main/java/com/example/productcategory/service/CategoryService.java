package com.example.productcategory.service;

import java.util.List;

import com.example.productcategory.dto.CategoryDTO;


public interface CategoryService {
	List<CategoryDTO> getAllCategory();

	CategoryDTO getCategoryById(int id);

	CategoryDTO addCategory(CategoryDTO categoryDTO);

	CategoryDTO updateCategory(int id, CategoryDTO categoryDTO);

	void deleteById(int id);
}
