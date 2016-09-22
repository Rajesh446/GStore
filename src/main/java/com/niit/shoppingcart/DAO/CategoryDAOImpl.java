package com.niit.shoppingcart.DAO;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired 
	private Category category;

	@Autowired 
	private SessionFactory sessionFactory;
	
	public CategoryDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public Boolean save(Category category) {
		
		sessionFactory.getCurrentSession().save(category);
		return false;
	}

	public Boolean update(Category category) {
		
		sessionFactory.getCurrentSession().update(category);
		return false;

	}

	public Boolean delete(String id) {
		
		sessionFactory.getCurrentSession().delete(get(id));
		return false;

	}

	public Category get(String id) {
		String hql = "from Category where id= '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		return null;
	}

	public List<Category> list() {
		return null;
	}

}
