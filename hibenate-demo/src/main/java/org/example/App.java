package org.example;

import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try {
           SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
           Session session=sessionFactory.openSession();
           Student student=new Student("John","Doe","john@email.com");
           session.getTransaction().begin();
           session.persist(student);
           session.getTransaction().commit();
           System.out.println("Done!...");

       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
