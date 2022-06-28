package com.example.demo;

import java.util.Random;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.CouponDao;
import com.example.demo.model.Coupon;

@SpringBootApplication
@EnableEurekaClient
public class CouponServiceApplication implements CommandLineRunner{
private final CouponDao couponDao;



	public CouponServiceApplication(CouponDao couponDao) {
	
	this.couponDao = couponDao;
}

	public static void main(String[] args) {
		SpringApplication.run(CouponServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		couponDao.save(new Coupon(new Random().nextInt(1000), "CODE-A", 1.2));
		couponDao.save(new Coupon(new Random().nextInt(1000), "CODE-B", 2.2));
		couponDao.save(new Coupon(new Random().nextInt(1000), "CODE-C", 4.9));
		couponDao.save(new Coupon(new Random().nextInt(1000), "CODE-D", 1.0));
		
	}

}
