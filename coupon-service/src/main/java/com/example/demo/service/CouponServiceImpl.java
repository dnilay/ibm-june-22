package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.CouponDao;
import com.example.demo.model.Coupon;
@Service
public class CouponServiceImpl implements CouponService {
	
	private final CouponDao couponDao;
	

	public CouponServiceImpl(CouponDao couponDao) {
		
		this.couponDao = couponDao;
	}


	@Override
	public Coupon findByCouponCode(String couponCode) {
		
		return couponDao.findByCouponCode(couponCode);
	}

}
