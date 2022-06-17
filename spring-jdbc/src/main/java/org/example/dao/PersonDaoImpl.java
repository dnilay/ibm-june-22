package org.example.dao;

import org.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
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

    private DataSource dataSource;

    @Autowired
    public PersonDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Person> fetchAllPerson() throws SQLException {
        Connection connection= dataSource.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from person");

        System.out.println("id\tfirst_name\tlast_name\tage");
        List<Person> list=new ArrayList<Person>();
        while (resultSet.next())
        {
            list.add(new Person(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4)));
        }
        return list;
    }
}
