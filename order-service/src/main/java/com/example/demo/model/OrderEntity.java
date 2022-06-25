package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_table")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "order_name")
	private String orderName;
	@Column(name = "order_price")
	private double orderPrice;
	public OrderEntity() {
		
	}
	public OrderEntity(String orderName, double orderPrice) {
		
		this.orderName = orderName;
		this.orderPrice = orderPrice;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", orderName=" + orderName + ", orderPrice=" + orderPrice + "]";
	}
	
	

}
