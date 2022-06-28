package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Coupon;
import com.example.demo.service.CouponService;

@RestController

public class CouponServiceController {

	private final Environment environment;
	private final CouponService couponService;

	public CouponServiceController(Environment environment,CouponService couponService) {
		
		this.environment = environment;
		this.couponService=couponService;
	}
	@RequestMapping
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("coupon-ws is woring and listing on port: "+environment.getProperty("local.server.port"));
	}
	@GetMapping("/coupons/{couponCode}")
	public Coupon getCouponByCode(@PathVariable("couponCode")String couponCode)
	{
		return couponService.findByCouponCode(couponCode);
	}

}
