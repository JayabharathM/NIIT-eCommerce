package com.shopping.FashionWorldFrontend.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.shopping.FashionWorldBackend.dao.CategoryDAO;
import com.shopping.FashionWorldBackend.dao.ProductDAO;
import com.shopping.FashionWorldBackend.dao.SupplierDAO;
import com.shopping.FashionWorldBackend.model.Category;
import com.shopping.FashionWorldBackend.model.Product;
import com.shopping.FashionWorldBackend.model.Supplier;


@Controller
public class ProductController
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	

	@RequestMapping("/Product")
	public String showProduct(Model m)
	{
		
		
		Product product=new Product();
		
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("product",product);
		
		m.addAttribute("supplist",this.getSuppList());
		
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		boolean flag=true;
		m.addAttribute("flag",flag);
		
		return "Product";
	}
	
	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	public String insertProduct(@ModelAttribute("product") Product product,Model m,@RequestParam("pimage") MultipartFile filedet,BindingResult result)
	{
		System.out.println("---Product Inserted---");
		productDAO.insertUpdateProduct(product);	
		
		System.out.println("------Images Storing started------");
		

        String path="D:\\Amir\\AmirEcommerceProject\\FadshionWorldFrontend\\src\\main\\webapp\\resources\\images\\";
		String fileinfo=path+product.getProdid()+".jpg";
		File f=new File(fileinfo);
		
		if(!filedet.isEmpty())
		{
			try
			{
				byte buff[]=filedet.getBytes();
				FileOutputStream fos=new FileOutputStream(f);
				BufferedOutputStream bs = new BufferedOutputStream(fos);
				bs.write(buff);
			}
			catch(Exception e)
			{
				System.out.println("Exception arised");
			}
		}
		else
		{
			System.out.println("----File uploading problem----");
		}
		
		System.out.println("------Images Stored------");
		
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
	boolean	flag=true;
		m.addAttribute("flag",flag);
		return "Product";
	}
	
	@RequestMapping(value="/updateProduct/{prodid}",method=RequestMethod.GET)
	public String updateProduct(@PathVariable("prodid")int prodid,Model m)
	{
		System.out.println("id is "+prodid);
		
		Product product=productDAO.getProduct(prodid);
	//	productDAO.insertUpdateProduct(product);
		System.out.println(product.getProdid());
		m.addAttribute("product",product);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("supplist",this.getSuppList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("flag",false);
		return "Product";
	}
	
	@RequestMapping(value="/deleteProduct/{prodid}")
	public String deleteProduct(@PathVariable("prodid")int prodid,Model m)
	{
		
		Product product=productDAO.getProduct(prodid);
		productDAO.deleteProduct(product);
		
		Product product1=new Product();
		m.addAttribute("product",product1);
		m.addAttribute("catlist",this.getCatList());
		m.addAttribute("supplist",this.getSuppList());
		List<Product> prodlist=productDAO.getProductDetails();
		m.addAttribute("prodlist",prodlist);
		m.addAttribute("flag",true);
		return "Product";
	}
	
	public LinkedHashMap<Integer,String> getCatList()
	{
		List<Category> list=categoryDAO.getCategoryDetails();
		
		LinkedHashMap<Integer,String> catlist=new LinkedHashMap<Integer,String>();
		
		for(Category cat:list)
		{
			catlist.put(cat.getCatid(),cat.getCatname());
		}
		
		return catlist;
	}
	
	public LinkedHashMap<Integer,String> getSuppList()
	{
		List<Supplier> list=supplierDAO.getSupplierDetails();
		
		LinkedHashMap<Integer,String> supplist=new LinkedHashMap<Integer,String>();
		
		for(Supplier supp:list)
		{
			supplist.put(supp.getSuppid(),supp.getSuppname());
		}
		
		return supplist;
	}
	
/*	@RequestMapping(value="/displayproduct")
	public String displayProduct(Model m)
	{
		List<Product> prodlist=productDAO.getProductDetails();
		System.out.println("product list  getting printed "+prodlist);
		m.addAttribute("prodlist",prodlist);
		
		return "ProductPage";
	}*/
	@RequestMapping(value="/ProductDesc/{prodid}")
	public String showProductDesc(@PathVariable("prodid")int prodid, Model m)
	{
		Product product=productDAO.getProduct(prodid);
		m.addAttribute("prodinfo",product);
		
		return "ProductDesc";
	}

}
