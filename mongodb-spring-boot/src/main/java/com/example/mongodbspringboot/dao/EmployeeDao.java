package com.example.mongodbspringboot.dao;

import com.example.mongodbspringboot.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDao extends MongoRepository<Employee,Integer> {
}
