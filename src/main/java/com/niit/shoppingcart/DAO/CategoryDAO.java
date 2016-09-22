package com.niit.shoppingcart.DAO;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {

	public Boolean save(Category category);
	public Boolean update(Category category);
	public Boolean delete(String id);
	
	public Category get(String id);
	
	public List<Category> list();
}
