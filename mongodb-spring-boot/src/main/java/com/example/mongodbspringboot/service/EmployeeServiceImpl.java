package com.example.mongodbspringboot.service;

import com.example.mongodbspringboot.dao.EmployeeDao;
import com.example.mongodbspringboot.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeDao.findById(employeeId).get();
    }

    @Override
    public Employee updateEmployeeById(int employeeId, Employee employee) {
        Employee tempEmployee=employeeDao.findById(employeeId).get();

        tempEmployee.setFirstName(employee.getFirstName());
        tempEmployee.setLastName(employee.getLastName());
        tempEmployee.setEmail(employee.getEmail());
       
        employeeDao.save(tempEmployee);
        return tempEmployee;
    }
}
