package com.shopping.FashionWorldFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shopping.FashionWorldBackend.dao.UserDetailDAO;
import com.shopping.FashionWorldBackend.model.UserDetail;

@Controller
public class UserDetailController 
{
	@Autowired
	UserDetailDAO userDetailDAO;
	
	@RequestMapping("/Register")
	public String showUserDetail(Model m)
	{
		System.out.println("---UserDetail Page Displaying-----");
		/*List<UserDetail> userdetaillist=userDetailDAO.getUserDetailDetails();
		m.addAttribute("userdetail",userdetaillist);
		
		boolean flag=false;
		m.addAttribute("flag",flag);*/
		return "Register";
		
		
	}
	
	@RequestMapping(value="/InsertUserDetail",method=RequestMethod.POST)
	public String insertUserDetail(@ModelAttribute("userdetail") UserDetail userdetail,Model m)
	{
		System.out.println("---Add UserDetail Starting-----");
		userdetail.setRole("ROLE_USER");
        userdetail.setEnabled(true);
		userDetailDAO.insertUpdateUserDetail(userdetail);
		
		List<UserDetail> userdetaillist=userDetailDAO.getUserDetailDetails();
		m.addAttribute("userdetail",userdetaillist);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		System.out.println("---UserDetail Added----");
		return "Register2";
	}
	
	/*@RequestMapping(value="/updateUserDetail/{username}")
	public String updateUserDetail(@PathVariable("username") String username,Model m)
	{
		
		UserDetail userdetail=userDetailDAO.getUserDetail(username);
		System.out.println(userdetail.getUsername());
		m.addAttribute("userdetail",userdetail);
		
		List<UserDetail> userdetaillist=userDetailDAO.getUserDetailDetails();
		m.addAttribute("userdetail",userdetaillist);
		
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "Register";
	}
	
	@RequestMapping(value="/deleteUserDetail/{username}")
	public String deleteUserDetail(@PathVariable("username") String username,Model m)
	{
		
		UserDetail userdetail=userDetailDAO.getUserDetail(username);
		userDetailDAO.deleteUserDetail(userdetail);
		
		UserDetail userdetail1=new UserDetail();
		m.addAttribute("userdetail",userdetail1);
		
		List<UserDetail> userdetaillist=userDetailDAO.getUserDetailDetails();
		m.addAttribute("userdetail",userdetaillist);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Register";
	}*/
	

}
