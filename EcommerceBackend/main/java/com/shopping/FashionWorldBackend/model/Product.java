package com.shopping.FashionWorldBackend.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
public class Product implements Serializable
{
	@Id
	@GeneratedValue
	int prodid;
	
	@NotEmpty(message = "Please enter your Productname.")
	@Size(min = 4, max = 15, message = "Your product name must be within the specified size.")
	String prodname;
	
	@NotNull
	int catid;
	
	@NotNull
	int suppid;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 50)
	int quantity;
	
	@NotNull
	@Min(value = 1)
	int price;
	
	@NotEmpty
	@Size(min = 4, max = 50 , message = "Product description must be within the specified size")
	String ProdDesc;
	
	@Transient
	MultipartFile pimage;
	
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public int getSuppid() {
		return suppid;
	}
	public void setSuppid(int suppid) {
		this.suppid = suppid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getProdDesc() {
		return ProdDesc;
	}
	public void setProdDesc(String prodDesc) {
		ProdDesc = prodDesc;
	}
	

}
