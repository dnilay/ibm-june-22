package org.example.dao;

import org.example.model.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {

    public List<Person> fetchAllPersons() throws SQLException;

    public Person createPerson(Person person) throws SQLException;
    public Person findById(int id) throws SQLException;
}
