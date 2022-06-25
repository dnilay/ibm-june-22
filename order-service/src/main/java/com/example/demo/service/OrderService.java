package com.example.demo.service;

import java.util.List;

import com.example.demo.model.OrderEntity;

public interface OrderService {
	OrderEntity createOrder(OrderEntity orderEntity);

	List<OrderEntity> getOrders();

	OrderEntity findOrderById(int orderId);
	OrderEntity updateOrderByOrderId(int orderId,OrderEntity orderEntity);
	List<OrderEntity> findOrderByName(String orderName);
	void deleteById(int orderid);
}
