package com.shopping.FashionWorldBackend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopping.FashionWorldBackend.model.Category;

@Repository("categoryDAO")
public class CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public CategoryDAO(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void insertUpdateCategory(Category category)
	{
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(category);
	}
	
	@Transactional
	public Category getCategory(int catid)
	{
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,catid);
		session.close();
		return category;
	}
	
	@Transactional
	public void deleteCategory(Category category)
	{
		sessionFactory.getCurrentSession().delete(category);
	}
	
	@Transactional
	public List<Category> getCategoryDetails()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> list=query.list();
		session.close();
		return list;
	}

}
