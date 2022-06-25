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

	@Override
	@Transactional
	public OrderEntity updateOrderByOrderId(int orderId, OrderEntity orderEntity) {
		OrderEntity o = findOrderById(orderId);
		o.setOrderName(orderEntity.getOrderName());
		o.setOrderPrice(orderEntity.getOrderPrice());
		entityManager.merge(o);
		return o;
	}

	@Override
	@Transactional
	public List<OrderEntity> findOrderByName(String orderName) {
		TypedQuery<OrderEntity> query = entityManager
				.createQuery("SELECT O FROM OrderEntity O WHERE O.orderName=:oName", OrderEntity.class);
		query.setParameter("oName", orderName);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteById(int orderid) {
		// TODO Auto-generated method stub
		OrderEntity o = entityManager.find(OrderEntity.class, orderid);
		entityManager.remove(o);

	}

}
