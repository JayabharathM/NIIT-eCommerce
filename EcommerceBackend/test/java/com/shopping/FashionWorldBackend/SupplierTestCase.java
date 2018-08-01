package com.shopping.FashionWorldBackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shopping.FashionWorldBackend.dao.SupplierDAO;
import com.shopping.FashionWorldBackend.model.Supplier;

public class SupplierTestCase
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.shopping.FashionWorldBackend");
		
		context.refresh();
		
		// Inserting a Supplier Object.
		SupplierDAO supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
		
		//Insertion TestCase
		
		Supplier supplier=new Supplier();
		
		supplier.setSuppname("Bhopal Ltd");
		supplier.setAddress("Bhopal MP Nagar");
		
		

		supplierDAO.insertUpdateSupplier(supplier);		
		System.out.println("Supplier Inserted");
		
		//Retrieval TestCase
		
		/*Supplier supplier=supplierDAO.getSupplier(1);
		System.out.println("Supplier Name:"+supplier.getSuppname());
		System.out.println("Supplier Address:"+supplier.getAddress());*/
		
		//Deletion TestCase
		/*Supplier supplier=supplierDAO.getSupplier(1);
		supplierDAO.deleteSupplier(supplier);
		System.out.println("The Supplier Deleted");*/
		
		//Retrieving the Data
		
		/*List<Supplier> list=supplierDAO.getSupplierDetails();
		
		for(Supplier supplier:list)
		{
			System.out.println(supplier.getSuppid()+":"+supplier.getSuppname()+":"+supplier.getAddress());
		}*/
		
		//Update the Supplier
	/*	Supplier supplier=supplierDAO.getSupplier(3);
		supplier.setCatname("WifiEnMobile");
		supplierDAO.insertUpdateSupplier(supplier);
		System.out.println("The Supplier Updated");*/
	}

}
