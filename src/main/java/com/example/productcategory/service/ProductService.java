package com.example.productcategory.service;

import java.util.List;

import com.example.productcategory.dto.ProductDTO;


public interface ProductService {

	public List<ProductDTO> getAllProducts();

	public ProductDTO getProductById(int id);

	public ProductDTO save(ProductDTO productDTO, int id);

	public void delete(int productId);

	ProductDTO assignCategoryToProduct(int productId, int categoryId);
}
