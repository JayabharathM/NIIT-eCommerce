package com.shopping.FashionWorldFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.FashionWorldBackend.dao.CartDAO;
import com.shopping.FashionWorldBackend.dao.ProductDAO;
import com.shopping.FashionWorldBackend.model.Cart;
import com.shopping.FashionWorldBackend.model.Product;

@Controller
public class CartController 
{
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/addToCart/{prodid}")
    public String addToCart(@PathVariable("prodid")int prodid, @RequestParam("quantity")int quantity,HttpSession session,Model m)
	{
		Cart cart=new Cart();
		
		String username=(String) session.getAttribute("username");
		java.util.Date dt=new java.util.Date();
		String date=dt.getYear()+":"+dt.getMonth()+":"+dt.getDate()+dt.getHours();
		cart.setCartid(username+date);
		cart.setProdid(prodid);
		cart.setQuantity(quantity);
		
		cart.setStatus("N");
		cart.setUsername(username);
		
		Product product=productDAO.getProduct(prodid);
		cart.setProdname(product.getProdname());
		cart.setPrice(product.getPrice());
		
		cartDAO.addToCart(cart);
		List<Cart> list=cartDAO.getCartItems(username);
		m.addAttribute("cartitems",list);
		
		return "Cart";
		 
		 
	}
		
    @RequestMapping(value="/updateCartItem/{citemid}")
	public String updateCartITem(@PathVariable("citemid")Long citemid, @RequestParam("quantity")int quantity,@RequestParam("update") String optype,HttpSession session,Model m)
	{
		Cart cart=cartDAO.getCartItem(citemid);
		String username=(String) session.getAttribute("username");
		if(optype.equals("DELETE"))
		{
		return	 "redirect:/deleteCartItem/"+citemid;
		}
		
		cart.setQuantity(quantity);
		cartDAO.updateCartItem(cart);
		
		List<Cart> list=cartDAO.getCartItems(username);
		
		m.addAttribute("cartitems",list);
		
		return "Cart";
	}
   /*public void delete(Cart c)
    {
    	cartDAO.deleteCartItem(c);
    }*/
    @RequestMapping(value="/deleteCartItem/{citemid}")
    public String deleteCartItem(@PathVariable("citemid")Long citemid,HttpSession session,Model m)
    {
    	Cart cart=cartDAO.getCartItem(citemid);
    	
    	String username=(String) session.getAttribute("username");
    	cartDAO.deleteCartItem(cart);
    	
        List<Cart> list=cartDAO.getCartItems(username);
		
		m.addAttribute("cartitems",list);
    	return "Cart";
    	
    }
    
   
    
}
