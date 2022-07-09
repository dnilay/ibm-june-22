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
}
