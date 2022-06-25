package com.example.demo.service;

import java.util.List;

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


	@Override
	public List<OrderEntity> getOrders() {
		// TODO Auto-generated method stub
		return orderDao.getOrders();
	}


	@Override
	public OrderEntity findOrderById(int orderId) {
		// TODO Auto-generated method stub
		return orderDao.findOrderById(orderId);
	}


	@Override
	public OrderEntity updateOrderByOrderId(int orderId,OrderEntity orderEntity) {
		// TODO Auto-generated method stub
		return orderDao.updateOrderByOrderId(orderId, orderEntity);
	}


	@Override
	public List<OrderEntity> findOrderByName(String orderName) {
		// TODO Auto-generated method stub
		return orderDao.findOrderByName(orderName);
	}

}
