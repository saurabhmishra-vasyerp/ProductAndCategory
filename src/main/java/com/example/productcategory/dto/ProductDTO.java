package com.example.productcategory.dto;

import com.example.productcategory.model.Category;
import com.example.productcategory.model.Product;

public class ProductDTO {
	public ProductDTO(Product product) {
	}

	private int productId;

	private String productName;

	private double productPrice;

	private String description;

	private Category categoryId;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

	public ProductDTO(int productId, String productName, double productPrice, String description, Category categoryId) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.description = description;
		this.categoryId = categoryId;
	}

	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", description=" + description + ", categoryId=" + categoryId + "]";
	}

}
