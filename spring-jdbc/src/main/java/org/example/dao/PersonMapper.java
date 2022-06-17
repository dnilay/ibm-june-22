package org.example.dao;

import org.example.model.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person=new Person();
        person.setPersonId(rs.getInt(1));
        person.setFirstName(rs.getString(2));
        person.setLastName(rs.getString(3));
        person.setAge(rs.getInt(4));
        return person;
    }
}
