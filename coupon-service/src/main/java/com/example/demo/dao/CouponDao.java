package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Coupon;

@Repository
public interface CouponDao extends JpaRepository<Coupon, Integer> {
	
	@Query
	Coupon findByCouponCode(String couponCode);

}
