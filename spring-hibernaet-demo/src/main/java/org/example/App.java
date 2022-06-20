package org.example;

import org.example.config.SpringConfig;
import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoImpl;
import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.example.service.EmployeeServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
           // ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
            ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
            EmployeeService employeeService=context.getBean("employeeService", EmployeeServiceImpl.class);
           // Employee employee=employeeService.createEmployee(new Employee("Sachin","Tendulkar","sachin@email.com"));
            //System.out.println(employee);
            /*Employee employee=employeeService.findEmployeeById(11);
            if (employee==null)
            {
                System.out.println("no such id");
            }
            else
            {
                System.out.println(employee);
            }*/
           /* List<Employee> list=employeeService.displayEmployees();
            for(Employee e:list)
            {
                System.out.println(e);
            }*/

           /* Employee employee=employeeService.updateEmployeeById(11);
            if (employee== null)
            {
                System.out.println("no such id...");
            }
            else
            {
                System.out.println(employee);
            }*/

            employeeService.deleteEmployeeById(11);

        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }

    }
}
