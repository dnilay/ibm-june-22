package org.example;

import org.example.dao.PersonDao;
import org.example.dao.PersonDaoImpl;
import org.example.model.Person;

import java.sql.*;
import java.util.List;

public class App
{

    public static void main( String[] args ) throws SQLException {
        PersonDao personDao=new PersonDaoImpl();

        try
        {
            List<Person> list=personDao.fetchAllPersons();
            System.out.println("ID\tFIRST_NAME\tLAST_NAME\tAGE");
            for(Person p:list)
            {
                System.out.println(p);
            }

        }
       catch (SQLException e)
       {
           e.printStackTrace();
       }

    }
}
