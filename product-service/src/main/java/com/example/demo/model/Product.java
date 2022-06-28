package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product_table")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "price")
	private double price;
	@Transient
	private String couponCode;
	@Column(name = "price_after_discount")
	private double priceAfterDiscount;
	public Product() {
		super();
	}
	public Product(String productName, double price, String couponCode, double priceAfterDiscount) {
		super();
		this.productName = productName;
		this.price = price;
		this.couponCode = couponCode;
		this.priceAfterDiscount = priceAfterDiscount;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getPriceAfterDiscount() {
		return priceAfterDiscount;
	}
	public void setPriceAfterDiscount(double priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}
	
	

}
