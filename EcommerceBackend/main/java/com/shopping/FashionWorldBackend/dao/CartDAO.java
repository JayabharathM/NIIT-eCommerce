package com.shopping.FashionWorldBackend.dao;

import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.shopping.FashionWorldBackend.model.Cart;

@Repository("cartDAO")
public class CartDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CartDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void addToCart(Cart cartitem)
	{
		sessionFactory.getCurrentSession().saveOrUpdate(cartitem);
	}
	
	public List<Cart> getCartItems(String username)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart where username='"+username+"' and status='N'");
		//query.setParameter("username",username);
		
		@SuppressWarnings("unchecked")
		List<Cart> list=query.list();
		return list;
   }
	
	@Transactional
	public void deleteCartItem(Cart cart)
	{
		Session session1=sessionFactory.getCurrentSession();
		
        session1.delete(cart);
        session1.flush();
		
		//sessionFactory.getCurrentSession().delete(cart);
	}
	
	public Cart getCartItem(Long citemid)
	{
		Session session=sessionFactory.openSession();
		
		Cart cart=(Cart)session.get(Cart.class,citemid);
		return cart;
	}
	
	@Transactional
	public void updateCartItem(Cart cart)
	{
		sessionFactory.getCurrentSession().update(cart);
	}

}
