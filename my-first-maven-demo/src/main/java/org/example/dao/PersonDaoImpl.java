package org.example.dao;

import org.example.ListEmptyException;
import org.example.factory.PersonConnectionFactory;
import org.example.model.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {


    private final Connection connection;
    private ResultSet resultSet;
    private Statement statement;
    private List<Person> list;
    private PreparedStatement preparedStatement;

    public PersonDaoImpl() throws SQLException {
        connection = PersonConnectionFactory.getMyConnection();
    }

    @Override
    public List<Person> fetchAllPersons() throws SQLException {
        list = new ArrayList<Person>();
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from person");
        while (resultSet.next()) {
            list.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        return list;
    }

    @Override
    public Person createPerson(Person person) throws SQLException {
        preparedStatement = connection.prepareStatement("insert into person(person_id,first_name,last_name,age) values(?,?,?,?)");
        preparedStatement.setInt(1, person.getPersonId());
        preparedStatement.setString(2, person.getFirstName());
        preparedStatement.setString(3, person.getLastName());
        preparedStatement.setInt(4, person.getAge());
        preparedStatement.executeUpdate();
        return person;
    }

    @Override
    public Person findById(int id) throws SQLException {
        list = new ArrayList<Person>();
        preparedStatement = connection.prepareStatement("select * from person where person_id=?");
        preparedStatement.setInt(1,id);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            list.add(new Person(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4)));
        }
        if (list.isEmpty())
        {
            throw new ListEmptyException("list is empty");
        }
        return list.get(0);
    }
}
