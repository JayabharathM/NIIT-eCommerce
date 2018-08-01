package com.shopping.FashionWorldFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.FashionWorldBackend.dao.SupplierDAO;
import com.shopping.FashionWorldBackend.model.Category;
import com.shopping.FashionWorldBackend.model.Supplier;

@Controller
public class SupplierController
{
	@Autowired
	SupplierDAO supplierDAO;
	
	@RequestMapping("/Supplier")
	public String showSupplierPage(Model m)
	{
		System.out.println("---Supplier Page Displaying-----");
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		return "Supplier";
	}
	
	@RequestMapping(value="/AddSupplier",method=RequestMethod.POST)
	public String addSupplier(@RequestParam("suppname") String suppname,@RequestParam("Address") String Address, Model m)
	{
		System.out.println("---Add Supplier Starting-----");
		
		System.out.println(suppname+":::"+Address);
		
		Supplier supplier=new Supplier();
		supplier.setSuppname(suppname);
		supplier.setAddress(Address);
		
		supplierDAO.insertUpdateSupplier(supplier);
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		System.out.println("---Supplier Added----");
		return "Supplier";
	}
	
	@RequestMapping(value="/deleteSupplier/{suppid}")
	public String deleteSupplier(@PathVariable("suppid") int suppid,Model m)
	{
		System.out.println("-----Supplier deleted-----");
		Supplier supplier=supplierDAO.getSupplier(suppid);
		supplierDAO.deleteSupplier(supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/updateSupplier/{suppid}")
	public String getUpdateSupplier(@PathVariable("suppid") int suppid,Model m)
	{
		System.out.println("--- Getting Supplier Object to be Updated ---");
		
		Supplier supplier=supplierDAO.getSupplier(suppid);
		m.addAttribute("supplier",supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetail",list);
		
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "Supplier";
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public String updateSupplier(@RequestParam("suppid") int  suppid,@RequestParam("suppname") String suppname,@RequestParam("Address") String Address,Model m)
	{
		try
		{
		
   
		Supplier supplier=new Supplier();
	    supplier.setSuppid(suppid);
	    supplier.setSuppname(suppname);
	    supplier.setAddress(Address);
		
		supplierDAO.insertUpdateSupplier(supplier);
		
		List<Supplier> list=supplierDAO.getSupplierDetails();
		m.addAttribute("suppdetail",list);
		
		boolean flag=false;
		m.addAttribute("flag",flag);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		
		}
		return "Supplier";
		
	
	
	}

}
