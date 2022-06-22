package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Person;

public interface PersonService {
	List<Person> getAllPersons();
	
	Person createPerson(Person person);
	
	Optional<Person> getPersonById(int personId);
	
	void deletePerson(int personId);

}
