package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.OrderEntity;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@ExceptionHandler
	public ResponseEntity<?> handleNumberFormatException(NumberFormatException e)
	{
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("please provide valid order-id");
	}

	@PostMapping
	public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderEntity orderEntity) {
		OrderEntity o = orderService.createOrder(orderEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(o);
	}

	@GetMapping
	public ResponseEntity<List<OrderEntity>> getOrders() {
		return ResponseEntity.ok(orderService.getOrders());
	}

	@GetMapping("/{orderId}")
	public ResponseEntity<?> findOrderById(@PathVariable("orderId") int orderId) {
		OrderEntity orderEntity = null;
		try {
			orderEntity = orderService.findOrderById(orderId);

		} catch (Exception e) {
			throw new NumberFormatException("please provide valid order-id");
		}
		if (orderEntity == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("order with orderid " + orderId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(orderEntity);
		}

	}

}
