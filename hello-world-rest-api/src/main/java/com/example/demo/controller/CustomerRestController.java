package com.example.demo.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {

	private final CustomerDao customerDao;

	public CustomerRestController(CustomerDao customerDao) {

		this.customerDao = customerDao;
	}

	/*
	 * @GetMapping public ResponseEntity<Customer> createCustomer() { Customer
	 * customer = new Customer(new Random().nextInt(1000), "John", "Doe",
	 * "john@email.com"); return
	 * ResponseEntity.status(HttpStatus.OK).body(customer); }
	 * 
	 * @PostMapping public ResponseEntity<Customer> createNewCustomer(@RequestBody
	 * Customer customer) { return
	 * ResponseEntity.status(HttpStatus.CREATED).body(customer); }
	 */
	@GetMapping
	public ResponseEntity<Collection<Customer>> getAllCustomers() {
		return ResponseEntity.status(HttpStatus.OK).body(customerDao.getAllCustomers());
	}

	@PostMapping
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer c=customerDao.createCustomer(customer);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(c);
	}

}
