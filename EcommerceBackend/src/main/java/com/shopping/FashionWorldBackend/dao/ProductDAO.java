package com.shopping.FashionWorldBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.FashionWorldBackend.model.Product;

@Repository("productDAO")
public class ProductDAO
{

	@Autowired
	SessionFactory sessionFactory;
	
	public ProductDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateProduct(Product product)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
	
	public Product getProduct(int prodid)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,prodid);
		System.out.println(product.getProdname());
		session.close();
		return product;
	}
	
	@Transactional
	public void deleteProduct(Product product)
	{
		sessionFactory.getCurrentSession().delete(product);
	}
	
	
	public List<Product> getProductDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		@SuppressWarnings("unchecked")
		List<Product> list=query.list();
		session.close();
		return list;
	}


}
