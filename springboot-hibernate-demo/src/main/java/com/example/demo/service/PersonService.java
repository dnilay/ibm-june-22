package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Person;

public interface PersonService {
	List<Person> getAllPersons();
	
	Person createPerson(Person person);
	
	Person getPersonById(int personId);

}
