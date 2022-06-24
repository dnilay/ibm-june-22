package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.OrderEntity;

public interface OrderDao {
	
	OrderEntity createOrder(OrderEntity orderEntity);
	List<OrderEntity> getOrders();

}
