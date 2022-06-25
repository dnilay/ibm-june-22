package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.response.CustomerResponse;
import com.example.demo.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {

	private final Environment environment;

	private final CustomerService customerService;

	@GetMapping("/status")
	public ResponseEntity<?> getStatus() {
		return ResponseEntity.status(HttpStatus.OK)
				.body("customer-ws is up and running on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody Customer customer) {
		Customer tempCustomer = customerService.createCustomer(customer);
		CustomerResponse response = new CustomerResponse();
		response.setFirstName(tempCustomer.getFirstName());
		response.setLastName(tempCustomer.getLastName());
		response.setEmail(tempCustomer.getEmail());
		response.setCustomerId(tempCustomer.getCustomerId());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers()
	{
		List<Customer> customers=customerService.getAllCustomers();
		List<CustomerResponse> customerResponses=new ArrayList<>();
		for(Customer tempCustomer:customers)
		{
			CustomerResponse response = new CustomerResponse();
			response.setFirstName(tempCustomer.getFirstName());
			response.setLastName(tempCustomer.getLastName());
			response.setEmail(tempCustomer.getEmail());
			response.setCustomerId(tempCustomer.getCustomerId());
			customerResponses.add(response);
		}
		return ResponseEntity.status(HttpStatus.OK).body(customerResponses);
	}

}
