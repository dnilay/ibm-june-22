package com.example.demo.model;

public class CouponProxy {
	
	private int couponId;
	private String couponCode;
	private double dicount;
	public CouponProxy() {
		super();
	}
	public CouponProxy(int couponId, String couponCode, double dicount) {
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
