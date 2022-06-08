package org.example;

import java.sql.*;

public class App
{
    public static void main( String[] args )
    {


        try
        {
            //step-1
            //load the driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //step-2
            //make the connection with your mysql-server
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
            //step-3
            //create statement object which will help us to execute sql query on behalf of developer
            Statement statement=connection.createStatement();
            ResultSet resultSet= statement.executeQuery("select * from person");
            System.out.println("PERSON_ID\tFIRST_NAME\tLAST_NAME\tAGE\n===========================================\n");
            while(resultSet.next())
            {
                System.out.println(resultSet.getInt("person_id")+"\t"
                        +resultSet.getString("first_name")+
                        "\t"+resultSet.getString("last_name")
                        +"\t"+resultSet.getInt("age"));
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.toString());
        }

    }
}
