package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="PRODUCT")
@Component
public class Product {
	
	@Id
	private String id;
	private String name;
	private String categoryid;
	private String supplierid;
	private double price;
	private int stock;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategory_id(String categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplier_id(String supplierid) {
		this.supplierid = supplierid;
	}
	
		public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
