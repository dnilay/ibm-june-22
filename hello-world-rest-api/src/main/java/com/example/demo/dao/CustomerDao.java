package com.example.demo.dao;

import java.util.Collection;

import com.example.demo.model.Customer;

public interface CustomerDao {

	Collection<Customer> getAllCustomers();

	Customer createCustomer(Customer customer);

}
