package org.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonConnectionFactory {

    private static Connection connection;

    public static Connection getMyConnection()throws SQLException
    {

        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
        return connection;
    }
}
