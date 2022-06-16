package org.example.demo;

import java.util.Random;

import org.example.demo.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext context;

	public static void main( String[] args )
    {
        try {
        	
        	context = new ClassPathXmlApplicationContext("applicationContext.xml");
        	Customer customer=context.getBean("customer",Customer.class);
        	
        	customer.setCustomerId(new Random().nextInt());
        	customer.setFirstName("John");
        	customer.setLastName("Doe");
        	customer.setEmail("john@email.com");
        	System.out.println(customer.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    }
}
