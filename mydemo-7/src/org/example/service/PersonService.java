package org.example.service;

import org.example.model.Person;

import java.util.Set;

public interface PersonService {

    public void createPerson(Person person);
    public Set<Person> fetchAllPerson();
    public void getPersonById(String personId);
}
