package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.entity.Person;
@Service
public class PersonServiceImpl implements PersonService {

	private final PersonDao personDao;
	
	
	public PersonServiceImpl(PersonDao personDao) {
		
		this.personDao = personDao;
	}


	@Override
	public List<Person> getAllPersons() {
		
		return personDao.findAll();
	}

}
