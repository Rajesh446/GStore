package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="PRODUCT")
@Component
public class Product {
	
@Id
@GeneratedValue
 private int id;
private String name;

@ManyToOne
@JoinColumn(name="category_id",updatable=false,insertable=false,nullable=false)
private int categoryid;

@ManyToOne
@JoinColumn(name="supplier_id",updatable=false,insertable=false,nullable=false)
private int supplierid;
private double  price;
private int stock;


public int getId() {
	return id;
}
public String getName() {
	return name;
}

public double getPrice() {
	return price;
}
public void setId(int id) {
	this.id = id;
}
public void setName(String name) {
	this.name = name;
}
public void setPrice(double price) {
	this.price = price;
}
public int getCategoryid() {
	return categoryid;
}
public void setCategoryid(int categoryid) {
	this.categoryid = categoryid;
}
public int getSupplierid() {
	return supplierid;
}
public void setSupplierid(int supplierid) {
	this.supplierid = supplierid;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
 
}
