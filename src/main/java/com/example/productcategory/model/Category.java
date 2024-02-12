package com.example.productcategory.model;

import com.example.productcategory.dto.CategoryDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="category_id")
	private int Cid;
	@Column(name="category_name")
	private String Cname;
	@Column(name="category_description")
	private String Cdescription;
	
	public Category(CategoryDTO categoryDTO){
		this.Cid = categoryDTO.getCategoryId();
		this.Cname = categoryDTO.getCategoryName();
	}



	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getCdescription() {
		return Cdescription;
	}

	public void setCdescription(String cdescription) {
		Cdescription = cdescription;
	}

	

	public Category(int cid, String cname, String cdescription) {
		super();
		Cid = cid;
		Cname = cname;
		Cdescription = cdescription;
		
	}



	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
