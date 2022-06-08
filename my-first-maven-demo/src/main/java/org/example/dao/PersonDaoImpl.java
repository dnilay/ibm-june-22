package org.example.dao;

import org.example.factory.PersonConnectionFactory;
import org.example.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {


    private Connection connection;
    private ResultSet resultSet;
    private Statement statement;
    private List<Person> list;

    public PersonDaoImpl() throws SQLException {
       connection=PersonConnectionFactory.getMyConnection();
    }

    @Override
    public List<Person> fetchAllPersons() throws SQLException {
        list=new ArrayList<Person>();
        statement=connection.createStatement();
        resultSet= statement.executeQuery("select * from person");
        while (resultSet.next())
        {
            list.add(new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
        }
        return list;
    }
}
