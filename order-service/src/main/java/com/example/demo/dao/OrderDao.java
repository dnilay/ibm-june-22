package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.OrderEntity;

public interface OrderDao {

	OrderEntity createOrder(OrderEntity orderEntity);

	List<OrderEntity> getOrders();

	OrderEntity findOrderById(int orderId);
	
	OrderEntity updateOrderByOrderId(int orderId,OrderEntity orderEntity);
	List<OrderEntity> findOrderByName(String orderName);
	void deleteById(int orderid);

}
