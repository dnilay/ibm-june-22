package org.example;

import org.example.dao.StudentDao;
import org.example.dao.StudentDaoImpl;
import org.example.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       try {
           StudentDao studentDao=new StudentDaoImpl();
           Student student=studentDao.createStudent(new Student("Marry","Public","marry@email.com"));
            System.out.println(student+" Created...!");
           List<Student> list=studentDao.getAllStudents();
           for(Student s:list)
           {
               System.out.println(s);
           }
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }
}
