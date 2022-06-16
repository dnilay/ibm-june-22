package org.example;

import org.example.model.Coach;
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
        Coach coach=context.getBean("theCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
    }
}
