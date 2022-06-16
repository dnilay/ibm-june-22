package org.example;

import org.example.model.Address;
import org.example.model.Coach;
import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
       /* Coach coach=context.getBean("swimmingCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        coach=context.getBean("basketBallCoach",Coach.class);
        System.out.println(coach.getDailyWorkout());
        coach=context.getBean("cricketCoach",Coach.class);
        System.out.println(coach.getDailyWorkout());*/

        Person person=context.getBean("person",Person.class);
        Address address=context.getBean("address",Address.class);
        address.setAddressLine1("Chennai");
        address.setAddressLine2("India");
        person.setFirstName("John");
        person.setLastName("Doe");
        person.setAddress(address);
        System.out.println(person);
    }
}
