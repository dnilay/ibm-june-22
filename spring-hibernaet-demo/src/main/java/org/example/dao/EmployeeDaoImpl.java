package org.example.dao;

import lombok.AllArgsConstructor;
import org.example.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
    private final SessionFactory sessionFactory;
    private Scanner scanner = new Scanner(System.in);
    private Session session;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> displayEmployees() {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query<Employee> query = session.createQuery("FROM Employee");
        List<Employee> employees = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return employees;
    }

    @Override

    public Employee createEmployee(Employee employee) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return employee;
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Employee employee = session.find(Employee.class, employeeId);
        session.getTransaction().commit();
        session.close();
        if (employee == null) {
            return null;
        } else {
            return employee;
        }

    }

    @Override
    public void deleteEmployeeById(int employeeId) {



        session= sessionFactory.openSession();
        session.getTransaction().begin();
        Employee employee=session.find(Employee.class,employeeId);
        if (employee==null)
        {
            System.out.println("no such id found.");

        }
        else
        {
            session.remove(employee);
            session.getTransaction().commit();
            session.close();
            System.out.println("removed succeed..");
        }

    }

    @Override
    public Employee updateEmployeeById(int employeeId) {
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Employee employee = session.find(Employee.class, employeeId);
        if (employee == null) {
            System.out.println("no such id found.");
            return null;
        } else {
            System.out.print("Enter New First Name: ");
            String fName = scanner.next();
            System.out.print("Enter New Last Name: ");
            String lName = scanner.next();
            System.out.print("Enter New Email Name: ");
            String email = scanner.next();
            employee.setFirstName(fName);
            employee.setLastName(lName);
            employee.setEmail(email);
            session.merge(employee);
            session.getTransaction().commit();
            session.close();
            System.out.println("Update succeed..");
            return employee;
        }

    }
}

