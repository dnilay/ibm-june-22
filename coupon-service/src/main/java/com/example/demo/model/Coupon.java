package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "coupon_table")
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "coupon_id")
	private int couponId;
	@Column(name = "coupon_code",unique = true)
	private String couponCode;
	private double dicount;
	public Coupon() {
		super();
	}
	public Coupon(int couponId, String couponCode, double dicount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.dicount = dicount;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public double getDicount() {
		return dicount;
	}
	public void setDicount(double dicount) {
		this.dicount = dicount;
	}
	
	

}
