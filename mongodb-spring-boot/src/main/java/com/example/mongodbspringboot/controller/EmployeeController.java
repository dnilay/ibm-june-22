package com.example.mongodbspringboot.controller;

import com.example.mongodbspringboot.model.Employee;
import com.example.mongodbspringboot.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.ResultSet;
import java.util.List;
import java.util.Random;

@Controller
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping("/employees")

    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee)
    {
        employee.setEmployeeId(new Random().nextInt(1000));
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return ResponseEntity.ok(employeeService.fetchAllEmployees());
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getById(@PathVariable("employeeId") int employeeId)
    {
        return ResponseEntity.ok(employeeService.findEmployeeById(employeeId));
    }


}
