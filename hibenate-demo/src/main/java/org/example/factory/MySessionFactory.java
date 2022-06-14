package org.example.factory;

import org.example.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySessionFactory {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
        sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        return sessionFactory;
    }
}
