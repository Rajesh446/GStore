package com.niit.shoppingcart.config;

import java.util.Properties;

import javax.sql.DataSource;
 
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import com.niit.shoppingcart.DAO.CategoryDAO;
import com.niit.shoppingcart.DAO.CategoryDAOImpl;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Category;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
import com.niit.shoppingcart.model.User;
 
@Configuration
@ComponentScan("com.niit.shoppingcart")
@EnableTransactionManagement

public class ApplicationContextConfig {
 
    @Bean(name = "H2dataSource")
    public DataSource getH2DataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        String url="jdbc:h2:~/test;" + 
        	"INIT = CREATE SCHEMA IF NOT EXISTS TEST";
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl(url);
        dataSource.setUsername("sa");
        dataSource.setPassword("");
           
        return dataSource;
    }
    
    
    private Properties getHibernateProperties(){
    	Properties properties = new Properties();
    	properties.put("hibernate.show_sql", "true");
    	properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    	return properties;
    }
 
    @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource)  {
     LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
     sessionBuilder.addProperties(getHibernateProperties());
     sessionBuilder.addAnnotatedClasses(Category.class);
     sessionBuilder.addAnnotatedClasses(Supplier.class);
     sessionBuilder.addAnnotatedClasses(Product.class);
     sessionBuilder.addAnnotatedClasses(User.class);
     sessionBuilder.addAnnotatedClasses(Cart.class);
     
     return sessionBuilder.buildSessionFactory();
     
    }
    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
 
        return transactionManager;
    }
 
    @Bean(name = "categoryDAO")
    public CategoryDAO getCategoryDAO(SessionFactory sessionFactory) {
        return new CategoryDAOImpl(sessionFactory);
    }
 
  
    
}
