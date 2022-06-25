package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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

	@Override
	@Transactional
	public List<OrderEntity> getOrders() {
		TypedQuery<OrderEntity> query = entityManager.createQuery("SELECT O FROM OrderEntity O", OrderEntity.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public OrderEntity findOrderById(int orderId) {

		OrderEntity o = entityManager.find(OrderEntity.class, orderId);

		System.out.println(o);
		return o;
	}

}
