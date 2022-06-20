package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> displayEmployees() {
        return employeeDao.displayEmployees();
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }

    @Override
    public Employee findEmployeeById(int employeeId) {
        return employeeDao.findEmployeeById(employeeId);
    }

    @Override
    public void deleteEmployeeById(int employeeId) {
        employeeDao.deleteEmployeeById(employeeId);
    }

    @Override
    public Employee updateEmployeeById(int employeeId) {
        return employeeDao.updateEmployeeById(employeeId);
    }
}
