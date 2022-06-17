package org.example.dao;

import org.example.model.Person;

import java.sql.SQLException;

import java.util.List;

public interface PersonDao {

    public List<Person> fetchAllPerson() throws SQLException;

    public Person getPersonById(int personId);

    public Person createPerson(Person person);
    public Person updatePerson(int personId,Person person);
}
