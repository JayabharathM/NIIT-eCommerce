package com.shopping.FashionWorldBackend;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.FashionWorldBackend.dao.CartDAO;
import com.shopping.FashionWorldBackend.model.Cart;

public class CartTestCase 
{
	public static void main(String args[])
	{
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.shopping.FashionWorldBackend");
		context.refresh();
		
		CartDAO cartDAO=(CartDAO)context.getBean("cartDAO");
		
		Cart cart=new Cart();
		cart.setCartid("1001");
		cart.setProdid(3);
		cart.setProdname("Samsung Galaxy7");
		cart.setPrice(12000);
		cart.setQuantity(2);
		cart.setStatus("N");
		cart.setUsername("harish");
		
		cartDAO.addToCart(cart);
		System.out.println("Added to cart");
		
		List<Cart> list = cartDAO.getCartItems("harish");
		
		for(Cart cat:list)
		{
			System.out.println(cat.getCartid()+"----");
			System.out.println(cat.getProdid()+"----");
			System.out.println(cat.getProdname()+"----");
			System.out.println(cat.getPrice()+"----");
			System.out.println(cat.getQuantity()+"---");
		}
		
		System.out.println("Cart Item Displayed");
	}

}
