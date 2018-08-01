package com.shopping.FashionWorldBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.FashionWorldBackend.dao.UserDetailDAO;
import com.shopping.FashionWorldBackend.model.UserDetail;

public class UserDetailTestCase 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.shopping.FashionWorldBackend");
		
		context.refresh();
		
		// Inserting a UserDetail Object.
		UserDetailDAO userdetailDAO=(UserDetailDAO)context.getBean("userDetailDAO");
		
		//Insertion TestCase
		
		UserDetail userdetail=new UserDetail();
		
		userdetail.setUsername("Amirh");
		userdetail.setPassword("amir123");
		userdetail.setCustName("Amir Hussain");
		userdetail.setRole("USER_ROLE");
		userdetail.setEnabled(true);
		userdetail.setEmail("amirhuss@gmail");
		userdetail.setAddress("Bhopal");
		userdetail.setMobile("1234567890");
		
		
		userdetailDAO.insertUpdateUserDetail(userdetail);		
		System.out.println("UserDetail Inserted");
		
		//Retrieval TestCase
		
		/*UserDetail userdetail=userdetailDAO.getUserDetail(1);
		System.out.println("UserDetail Name:"+userdetail.getUsername());
		System.out.println("UserDetail Address:"+userdetail.Address());*/
		
		//Deletion TestCase
		/*UserDetail userdetail=userdetailDAO.getUserDetail(1);
		userdetailDAO.deleteUserDetail(userdetail);
		System.out.println("The UserDetail Deleted");*/
		
		//Retrieving the Data
		
		/*List<UserDetail> list=userdetailDAO.getUserDetailDetails();
		
		for(UserDetail userdetail:list)
		{
			System.out.println(userdetail.getUsername()+":"+userdetail.getPassword()+":"+userdetail.getRole());
		}*/
		
		//Update the UserDetail
	/*	UserDetail userdetail=userdetailDAO.getUserDetail(3);
		userdetail.setUsername("Sohail");
		userdetailDAO.insertUpdateUserDetail(userdetail);
		System.out.println("The UserDetail Updated");*/
	}

}
