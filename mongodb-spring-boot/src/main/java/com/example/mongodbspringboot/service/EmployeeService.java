package com.example.mongodbspringboot.service;

import com.example.mongodbspringboot.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);
    List<Employee> fetchAllEmployees();
}
