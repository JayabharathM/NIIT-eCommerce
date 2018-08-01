package com.shopping.FashionWorldBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment 
{
	@Id
	@GeneratedValue
	int paymentid;
	String cartid;
	int price;
	int cardnumber;
	
	public int getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(int cardnumber) {
		this.cardnumber = cardnumber;
	}
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public String getCartid() {
		return cartid;
	}
	public void setCartid(String cartid) {
		this.cartid = cartid;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
