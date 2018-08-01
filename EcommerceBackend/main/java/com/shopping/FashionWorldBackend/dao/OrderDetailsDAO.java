package com.shopping.FashionWorldBackend.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.FashionWorldBackend.model.OrderDetails;
import com.shopping.FashionWorldBackend.model.UserDetail;

@Repository("orderDetailsDAO")
public class OrderDetailsDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public OrderDetailsDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertOrderDetails(OrderDetails orderDetails)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(orderDetails);
	}
	
	public OrderDetails getOrderDetails(String username)
	{
		Session session=sessionFactory.openSession();
		OrderDetails orderDetails=(OrderDetails)session.get(OrderDetails.class,username);
		session.close();
		return orderDetails;
	}

}
