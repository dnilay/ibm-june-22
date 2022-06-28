package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.CouponProxy;
import com.example.demo.model.Product;

@RestController
public class ProductController {

	
	private final ProductDao productDao;
	
	private final RestTemplate restTemplate;

	public ProductController(ProductDao productDao,RestTemplate restTemplate) {
		
		this.productDao = productDao;
		this.restTemplate=restTemplate;
	}
	
	@PostMapping("/products")
	
	public ResponseEntity<?> createProduct(@RequestBody Product product)
	{
		CouponProxy couponProxy=restTemplate.getForObject("http://192.168.0.103:8001/coupons/"+product.getCouponCode(), CouponProxy.class);
		System.out.println(couponProxy);
		
		product.setPriceAfterDiscount(product.getPrice()-couponProxy.getDicount());
		System.out.println(couponProxy.getDicount());
		Product p=productDao.save(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
}
