package org.example;

import org.example.config.SpringConfig;
import org.example.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        Customer customer=context.getBean("c",Customer.class);
        customer.setCustomerId(100);
        customer.setCustomerName("John Doe");
        System.out.println(customer);
    }
}
