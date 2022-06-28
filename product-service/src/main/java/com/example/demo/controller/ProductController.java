package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.CouponProxy;
import com.example.demo.model.Product;

@RestController
public class ProductController {

	
	private final ProductDao productDao;
	
	private final RestTemplate restTemplate;
	private final Environment environment;

	public ProductController(ProductDao productDao,RestTemplate restTemplate,Environment environment) {
		
		this.productDao = productDao;
		this.restTemplate=restTemplate;
		this.environment=environment;
	}
	
	@RequestMapping
	public ResponseEntity<?> getStatus()
	{
		return ResponseEntity.ok("product-ws is up and runing on port: "+environment.getProperty("local.server.port"));
	}
	@PostMapping("/products")
	
	public ResponseEntity<?> createProduct(@RequestBody Product product)
	{
		CouponProxy couponProxy=restTemplate.getForObject("http://localhost:8888/COUPON-WS/coupons/"+product.getCouponCode(), CouponProxy.class);
		System.out.println(couponProxy);
		
		product.setPriceAfterDiscount(product.getPrice()-couponProxy.getDicount());
		System.out.println(couponProxy.getDicount());
		Product p=productDao.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
}
