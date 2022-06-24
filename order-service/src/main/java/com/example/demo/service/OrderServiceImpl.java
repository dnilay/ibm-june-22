package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.model.OrderEntity;

@Service
public class OrderServiceImpl implements OrderService {
	
	private final OrderDao orderDao;
	

	public OrderServiceImpl(OrderDao orderDao) {
		
		this.orderDao = orderDao;
	}


	@Override
	public OrderEntity createOrder(OrderEntity orderEntity) {
		// TODO Auto-generated method stub
		return orderDao.createOrder(orderEntity);
	}

}
