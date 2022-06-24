package com.example.demo.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.OrderEntity;
@Repository
@EnableTransactionManagement
public class OrderDaoImpl implements OrderDao {

	private final EntityManager entityManager;
	
	
	public OrderDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	@Transactional
	public OrderEntity createOrder(OrderEntity orderEntity) {
		
		entityManager.persist(orderEntity);
		
		return orderEntity;
	}

}
