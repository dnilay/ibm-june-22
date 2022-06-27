package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CouponServiceController {

	private final Environment environment;

	public CouponServiceController(Environment environment) {
		super();
		this.environment = environment;
	}
	@RequestMapping
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("coupon-ws is woring and listing on port: "+environment.getProperty("local.server.port"));
	}

}
