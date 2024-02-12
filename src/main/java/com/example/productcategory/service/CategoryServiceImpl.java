package com.example.productcategory.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productcategory.dto.CategoryDTO;
import com.example.productcategory.exception.CategoryNotFoundException;
import com.example.productcategory.model.Category;
import com.example.productcategory.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<CategoryDTO> getAllCategory() {
		// TODO Auto-generated method stub
		List<CategoryDTO> list = new ArrayList<>();
		List<Category> categoryList = categoryRepository.findAll();
		for (Category category : categoryList) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryName(category.getCname());
			categoryDTO.setCategoryId(category.getCid());

			list.add(categoryDTO);
		}
		return list;

	}

	@Override
	public CategoryDTO getCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(id)
				.orElseThrow(() -> new CategoryNotFoundException("Category Id not found: " + id));
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setCategoryId(category.getCid());
		categoryDTO.setCategoryName(category.getCname());
		return categoryDTO;

	}

	@Override
	public CategoryDTO addCategory(CategoryDTO categoryDTO) {
		// TODO Auto-generated method stub
		
		Category category = new Category(categoryDTO);
		Category save = categoryRepository.save(category);
		return new CategoryDTO(save);
		
	}

	@Override
	public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
	    // TODO Auto-generated method stub
	    Category category = categoryRepository.findById(id)
	            .orElseThrow(() -> new CategoryNotFoundException("category id is not found: " + id));
	    if (categoryDTO.getCategoryId() != 0) {
	        category.setCid(categoryDTO.getCategoryId());
	    }
	    if (categoryDTO.getCategoryName() != null) {
	        category.setCname(categoryDTO.getCategoryName());
	    }
	    Category save = categoryRepository.save(category);
	    return new CategoryDTO(save);
	}

		
	

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.findById(id)
				.orElseThrow(()-> new CategoryNotFoundException("not found"));
		categoryRepository.deleteById(id);

	}

}
