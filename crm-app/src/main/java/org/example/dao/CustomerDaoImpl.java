package org.example.dao;

import org.example.factory.MySessionFactory;
import org.example.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CustomerDaoImpl implements CustomerDao {
    private Session session;
    private SessionFactory sessionFactory;


    {
        sessionFactory= MySessionFactory.getSessionFactory();
    }
    @Override
    public Customer createCustomer(Customer customer) {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.persist(customer);
        session.getTransaction().commit();
        session.close();
        return customer;
    }
}
