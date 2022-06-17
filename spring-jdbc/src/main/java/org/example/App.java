package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource=context.getBean("dataSource",DataSource.class);
        Connection connection= dataSource.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet= statement.executeQuery("select * from person");

        System.out.println("id\tfirst_name\tlast_name\temail");
        while (resultSet.next())
        {
            System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+resultSet.getInt(4));
        }
    }
}
