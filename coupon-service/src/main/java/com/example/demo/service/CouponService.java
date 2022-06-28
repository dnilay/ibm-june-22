package com.example.demo.service;

import com.example.demo.model.Coupon;

public interface CouponService {
	Coupon findByCouponCode(String couponCode);

}
