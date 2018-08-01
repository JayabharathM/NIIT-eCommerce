package com.shopping.FashionWorldFrontend.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.FashionWorldBackend.dao.ProductDAO;
import com.shopping.FashionWorldBackend.model.Product;

@Controller
public class UserController 
{
    @Autowired
    ProductDAO productDAO;
    
	@RequestMapping("/login_Success")
	public String loginSuccess(HttpSession session,Model m)
	{
		System.out.println("-------Login Successful-----");
		String page=null;
		boolean loggedIn=true;
       
		//Retrieving the username
		String username=SecurityContextHolder.getContext().getAuthentication().getName();
		session.setAttribute("username", username);
		session.setAttribute("loggedIn",loggedIn);
		
		//Retrieving role
		Collection<GrantedAuthority> authorities=(Collection<GrantedAuthority>)SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		for (GrantedAuthority role:authorities)
		{
			System.out.println("Role:"+role.getAuthority()+"User Name:"+username+"-----");
			
			if(role.getAuthority().equals("ROLE_ADMIN"))
			{
				page="AdminHome";
			}
			else
			{
				List<Product> prodlist = productDAO.getProductDetails();
				System.out.println(prodlist);
				m.addAttribute("prodlist",prodlist);
				page="UserHome";
			}
		}
		return page;
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req,HttpServletResponse res )
	{
		req.getSession(false).invalidate();
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
	       new	SecurityContextLogoutHandler().logout(req, res,auth);
	       req.getSession().setAttribute("loggedIn",false);   
		
		
		return "Login";
	}

}
