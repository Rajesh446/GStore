package com.niit.shoppingcart.DAO;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	public Boolean saveOrUpdate(Category category) {
		try{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		}catch(Exception e)
		
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public Boolean delete(String id) {
		try{
		sessionFactory.getCurrentSession().delete(get(id));
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
		

	public Category get(String id) {
		String hql = "from Category where id= '"+id+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		
		List<Category> list = query.list();
		
		if(list==null||list.isEmpty())
		{
			return null;
			
		}
		
		return null;
	}

	public List<Category> list() {
		return null;
	}

}
