package org.example.factory;

import org.example.model.Customer;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
        sessionFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
        return sessionFactory;
    }
}
