package com.example.demo.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
	
	@GetMapping
	public ResponseEntity<Customer> createCustomer()
	{
		Customer customer=new Customer(new Random().nextInt(1000), "John", "Doe", "john@email.com");
		return ResponseEntity.status(HttpStatus.OK).body(customer);
	}

}
