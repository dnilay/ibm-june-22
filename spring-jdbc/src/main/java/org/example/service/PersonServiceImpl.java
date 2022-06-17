package org.example.service;

import org.example.dao.PersonDao;
import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component(value = "personService")
public class PersonServiceImpl implements PersonService{

    private PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public List<Person> fetchAllPerson() throws SQLException {
        return personDao.fetchAllPerson();
    }

    @Override
    public Person getPersonById(int personId) {
        return personDao.getPersonById(personId);
    }
}
