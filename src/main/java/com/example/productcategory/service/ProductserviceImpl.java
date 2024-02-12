package com.example.productcategory.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.productcategory.model.Category;
import com.example.productcategory.dto.CategoryDTO;
import com.example.productcategory.dto.ProductDTO;
import com.example.productcategory.exception.CategoryNotFoundException;
import com.example.productcategory.exception.ProductNotFoundException;
import com.example.productcategory.model.Category;
import com.example.productcategory.model.Product;
import com.example.productcategory.repository.CategoryRepository;
import com.example.productcategory.repository.ProductRepository;
@Service
public class ProductserviceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public List<ProductDTO> getAllProducts() {
		// TODO Auto-generated method stub
		List<ProductDTO> list = new ArrayList<>();
		List<Product> productlist = productRepository.findAll();
		for (Product product : productlist) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(product.getPoductId());
			productDTO.setProductName(product.getProductName());
			productDTO.setProductPrice(product.getProductPrice());
			productDTO.setDescription(product.getProductDescription());

			Category category = product.getCategory();
			if (category != null) {

				CategoryDTO categoryDTO = new CategoryDTO();
				categoryDTO.setCategoryId(product.getCategory().getCid());
				categoryDTO.setCategoryName(product.getCategory().getCname());
				productDTO.setCategoryId(category);
			}

			list.add(productDTO);
		}
		return list;
	
	}

	@Override
	public ProductDTO getProductById(int id) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product Not Found: " + id));
		Category category = product.getCategory();

		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(product.getProductQuantity());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setDescription(product.getProductDescription());

		if (category != null) {
			CategoryDTO categoryDTO = new CategoryDTO();
			categoryDTO.setCategoryId(product.getCategory().getCid());
			categoryDTO.setCategoryName(product.getCategory().getCname());
			productDTO.setCategoryId(category);
		}

		return productDTO;
	}

	@Override
	public ProductDTO save(ProductDTO productDTO, int id) {
		// TODO Auto-generated method stub
		if (id == 0) {
			Product product = new Product();
			Category category = null; // Allow null library for new student
			if (productDTO.getCategoryId() != null) {
				category = categoryRepository.findById(productDTO.getCategoryId().getCid())
						.orElseThrow(() -> new ProductNotFoundException("Product not found"));

//				category = new Category();
				category.setCid(productDTO.getCategoryId().getCid());
				category.setCname(productDTO.getCategoryId().getCname());
//				categoryRepository.save(category);
				product.setCategory(category);
			}
			product.setCategory(category);
			product.setProductName(productDTO.getProductName());
			product.setProductPrice(productDTO.getProductPrice());
			product.setProductDescription(productDTO.getDescription());
			productRepository.save(product);
		} else {
			// For Update Products
			Optional<Product> optionalProduct = productRepository.findById((int) id);
//			Product product = optionalProduct.orElseThrow(() -> new ProductNotFoundException("Product ID is not found"));

			if (optionalProduct.isPresent()) {
				Product productEdit = optionalProduct
						.orElseThrow(() -> new ProductNotFoundException("Product ID is not found"));
				if (productDTO.getProductName() != null) {
					productEdit.setProductName(productDTO.getProductName());
				}
				if (productDTO.getProductPrice() != 0) {
					productEdit.setProductPrice(productDTO.getProductPrice());
				}
				if (productDTO.getDescription() != null) {
					productEdit.setProductDescription(productDTO.getDescription());
				}
				Category categoryEdit = productEdit.getCategory();
				if (categoryEdit != null && productDTO.getCategoryId() != null) {
					categoryEdit.setCid(productDTO.getProductId());
					categoryEdit.setCname(productDTO.getProductName());
				}
				productRepository.save(productEdit);
			}
		}
		return productDTO;
	}

	@Override
	public void delete(int productId) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product Id is Not Found"));
		productRepository.deleteById(productId);
		
	}

	@Override
	public ProductDTO assignCategoryToProduct(int productId, int categoryId) {
		// TODO Auto-generated method stub
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + productId));
		if (product.getCategory() != null && product.getCategory().getCid() == categoryId) {
			throw new CategoryNotFoundException("This Category already assigned to this product.");
		}
		
		  // Retrieve the category by ID
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + categoryId));
        
        // Assign the category to the product
        product.setCategory(category);

		productRepository.save(product);
		return new ProductDTO(product);
	
	}
	
	
	

}
