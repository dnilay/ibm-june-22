package org.example;

import org.example.config.SpringConfig;
import org.example.model.Person;
import org.example.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
       // ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        PersonService personService=context.getBean("personService",PersonService.class);
        List<Person> list=personService.fetchAllPerson();
        for(Person p: list)
        {
            System.out.println(p.getPersonId()+"\t\t"+p.getFirstName()+"\t\t"+p.getLastName()+"\t\t"+p.getAge());
        }

        Person person=personService.getPersonById(800);
        if(person==null)
        {
            System.out.println("no such id found...");
        }
        else {
            System.out.println("found \n"+person);
        }


    }
}
