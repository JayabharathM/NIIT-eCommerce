package com.shopping.FashionWorldFrontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.FashionWorldBackend.dao.CartDAO;
import com.shopping.FashionWorldBackend.dao.PaymentDAO;
import com.shopping.FashionWorldBackend.dao.ProductDAO;
import com.shopping.FashionWorldBackend.model.Cart;
import com.shopping.FashionWorldBackend.model.Payment;
import com.shopping.FashionWorldBackend.model.Product;

@Controller
public class PageController  
{
	
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	PaymentDAO paymentDAO;
	
	@RequestMapping("/AboutUs")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/")
	public String showIndex(HttpServletRequest req)
	{
		req.getSession().setAttribute("loggedIn",false);
		System.out.println(req.getUserPrincipal().getName());
		return "index";
	}
	
	
	@RequestMapping("/ContactUs")
	public String showContactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/Login")
	public String showLogin(Model m)
	{
		
		
		return "Login";
	}
	@RequestMapping("/ProductPage")
	public String showProducts(Model m,HttpSession s)
	{
		List<Product> prodlist=productDAO.getProductDetails();
		System.out.println("product list getting printed "+prodlist);
		m.addAttribute("prodlist",prodlist);
		boolean status=Boolean.parseBoolean(s.getAttribute("loggedIn").toString());
		if(status)
		{
	      return "ProductPage";		
		}
		else
		{
		return "Login";

		}
	}
	@RequestMapping("/Payment/{citemid}")
	public String showPayment(@PathVariable Long citemid,Model m)
	{
		Cart cart=cartDAO.getCartItem(citemid);
		m.addAttribute("cart",cart);
		
		return "Payment";
	}
	
	@RequestMapping(value="/Payment/{citemid}",method=RequestMethod.POST)
	public String showPaymentcard(@PathVariable Long citemid,@RequestParam("mode")  String ptype,Model m,HttpSession session,@RequestParam("cardnumber")int cardnumber)
	{
		Cart cart=cartDAO.getCartItem(citemid);
		m.addAttribute("cart",cart);
		Payment obj=new Payment();
		if(ptype.equals("card"))
		{
			obj.setCardnumber(cardnumber);
			
		}
		else
		{
			obj.setCardnumber(0);
		}
	    obj.setCartid(cart.getCartid());
	    
	    float gtotal=Float.parseFloat(session.getAttribute("gtotal").toString());
  obj.setPrice((int)gtotal);
  paymentDAO.insertPaymentDetails(obj);
	    return "Successful";
	}

	
}
