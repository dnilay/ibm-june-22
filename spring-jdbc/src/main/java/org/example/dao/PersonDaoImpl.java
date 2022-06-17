package org.example.dao;

import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(value = "personDao")
public class PersonDaoImpl implements PersonDao{

   private JdbcTemplate jdbcTemplate;

   @Autowired
    public PersonDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> fetchAllPerson() throws SQLException {
       List<Person> list=jdbcTemplate.query("select * from person",new PersonMapper());

       return list;
    }

    @Override
    public Person getPersonById(final int personId) {
       List<Person> list=jdbcTemplate.query("select * from person where person_id=?", new PreparedStatementSetter() {
           @Override
           public void setValues(PreparedStatement ps) throws SQLException {
               ps.setInt(1,personId);
           }
       }, new PersonMapper());

       if(list.isEmpty())
       {
           return null;
       }
       else {
           return list.get(0);
       }

    }

    @Override
    public Person createPerson(Person person) {

       jdbcTemplate.update("insert into person(person_id,first_name,last_name,age) values(?,?,?,?)",person.getPersonId(),person.getFirstName(),person.getLastName(),person.getAge());
        return person;
    }
}
