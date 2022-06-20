package org.example.service;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> displayEmployees();
    Employee createEmployee(Employee employee);
    Employee findEmployeeById(int employeeId);
    void deleteEmployeeById(int employeeId);
    Employee updateEmployeeById(int employeeId);
}
