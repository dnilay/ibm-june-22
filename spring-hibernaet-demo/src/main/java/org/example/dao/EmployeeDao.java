package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> displayEmployees();
    Employee createEmployee(Employee employee);
    Employee findEmployeeById(int employeeId);
    void deleteEmployeeById(int employeeId);
    Employee updateEmployeeById(int employeeId);
}
