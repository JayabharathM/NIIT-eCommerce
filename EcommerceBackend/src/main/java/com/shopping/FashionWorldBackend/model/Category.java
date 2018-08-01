package com.shopping.FashionWorldBackend.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Category")
public class Category implements Serializable
{
	@Id
	@GeneratedValue
	int catid;
	
    @NotEmpty(message = "Please enter category name.")
    @Size(min = 4, max = 15, message = "Category name must be within the specified size.")
	String catname;
    
    @NotEmpty(message = "Please enter category description.")
    @Size(min = 5, max = 150, message = "Category description must be within the specified size.")
	String catdesc;
	
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getCatdesc() {
		return catdesc;
	}
	public void setCatdesc(String catdesc) {
		this.catdesc = catdesc;
	}

}
