package org.example.service;

import org.example.model.Person;

import java.util.List;
import java.util.Set;

public interface PersonService {

    public void createPerson(Person person);
    public List<Person> fetchAllPerson();
    public void getPersonById(String personId);
    public void updatePersonById(String personId,Person person);
}
