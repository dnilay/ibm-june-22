package com.example.demo.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Person createPerson(Person person) {
		// person.setPersonId(new Random().nextInt(1000));
		return personDao.save(person);
	}

	@Override
	public Optional<Person> getPersonById(int personId) {

		return personDao.findById(personId);
	}

	@Override
	public void deletePerson(int personId) {
		personDao.delete(getPersonById(personId).get());

	}

}
