package com.example.demo.service;

import java.util.List;

import com.example.demo.model.OrderEntity;

public interface OrderService {
	OrderEntity createOrder(OrderEntity orderEntity);

	List<OrderEntity> getOrders();

	OrderEntity findOrderById(int orderId);
}
