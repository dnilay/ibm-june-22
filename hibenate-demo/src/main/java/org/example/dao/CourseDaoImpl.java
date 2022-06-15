package org.example.dao;

import org.example.factory.MySessionFactory;
import org.example.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao{
    private  Session session;
    private SessionFactory sessionFactory;
    {
        sessionFactory= MySessionFactory.getSessionFactory();
    }
    @Override
    public Course createCourse(Course course) {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        session.persist(course);
        session.getTransaction().commit();
        session.close();
        return course;
    }

    @Override
    public List<Course> getAlCourse() {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Query query=session.createQuery("FROM Course ",Course.class);
        List<Course> list=query.getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public Course findCourseByCourseId(String courseId) {
        session=sessionFactory.getCurrentSession();
        session.getTransaction().begin();
        Query<Course> query=session.createQuery("FROM Course C WHERE C.course_id=:cId ",Course.class);
        query.setParameter("cId",courseId);
        List<Course> list=query.getResultList();

        session.getTransaction().commit();
        session.close();
        if(list.isEmpty())
        {

            return null;
        }
        else
        {
            return list.get(0);
        }

    }
}
