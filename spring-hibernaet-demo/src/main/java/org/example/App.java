package org.example;

import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.XMLFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            SessionFactory sessionFactory=context.getBean("sessionFactory",SessionFactory.class);
            Session session= sessionFactory.openSession();
            Employee employee=new Employee("John","Doe","john@email.com");
            session.getTransaction().begin();
            session.persist(employee);
            session.getTransaction().commit();
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }
}
