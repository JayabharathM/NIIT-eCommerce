package com.shopping.FashionWorldFrontend.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController  
{
	@RequestMapping("/AboutUs")
	public String showAboutUs()
	{
		return "AboutUs";
	}
	
	@RequestMapping("/")
	public String showIndex(HttpServletRequest req)
	{
	Principal p=	req.getUserPrincipal();
	System.out.println(p.getName());
		
	}
		return "index";
	}
	
	@RequestMapping("/Register")
	public String showRegister()
	{
		return "Register";
	}
	
	@RequestMapping("/ContactUs")
	public String showContactUs()
	{
		return "ContactUs";
	}
	
	@RequestMapping("/Login")
	public String showLogin()
	{
		return "Login";
	

}
