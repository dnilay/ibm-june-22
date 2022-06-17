package org.example.dao;

import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
}
