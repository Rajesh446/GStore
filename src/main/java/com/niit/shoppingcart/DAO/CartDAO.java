package com.niit.shoppingcart.DAO;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
	
	
	public List<Cart> list();
	public boolean save(Cart cart);
	public boolean update(Cart cart); 
	public boolean delete(Cart cart);	
	public Cart get(int id);	
	public Cart getproduct(int id);	
	/*public double getprice(int id);
	public int getsize(int id);*/
}
