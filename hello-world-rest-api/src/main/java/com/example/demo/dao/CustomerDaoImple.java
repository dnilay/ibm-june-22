package com.example.demo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public class CustomerDaoImple implements CustomerDao {
	private Map<Integer, Customer> map = null;

	public CustomerDaoImple() {
		map = new HashMap<Integer, Customer>();
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return map.values();
	}

	@Override
	public Customer createCustomer(Customer customer) {
		map.put(new Random().nextInt(1000), customer);
		return customer;
	}

}
