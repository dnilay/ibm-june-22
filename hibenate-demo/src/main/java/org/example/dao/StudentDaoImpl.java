package org.example.dao;

import org.example.factory.MySessionFactory;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDaoImpl implements StudentDao{
    private Session session;
    private SessionFactory sessionFactory;


    {
        sessionFactory= MySessionFactory.getSessionFactory();
    }
    @Override
    public Student createStudent(Student student) {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.persist(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Query query=session.createQuery("FROM Student",Student.class);
        List<Student>list=query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Student getStudentById(int id) {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Student student=session.get(Student.class,id);

        return student;
    }
}
