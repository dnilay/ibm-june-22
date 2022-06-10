package org.example;

import org.example.dao.PersonDao;
import org.example.dao.PersonDaoImpl;
import org.example.model.Person;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App
{
private static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args ) throws SQLException {
        PersonDao personDao=new PersonDaoImpl();
        int choice=0;


        try


        {
            do{
                System.out.println("1. Create A New Person. ");
                System.out.println("2. Display All Available Person. ");
                System.out.println("3. Find Person By ID: ");
                System.out.println("delete person by id. ");
                System.out.println("0. Exit. ");
                System.out.print("Enter Your choice: ");
                choice=scanner.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.println("Enter First Name: ");
                        String fName=scanner.next();
                        System.out.println("Enter Last Name: ");
                        String lName=scanner.next();
                        System.out.println("Enter Age: ");
                        int age=scanner.nextInt();
                        Person person=personDao.createPerson(new Person(new Random().nextInt(1000),fName,lName,age));
                        System.out.println("Person Created Successfully. "+person);
                        break;
                    case 2:

                        List<Person> list=personDao.fetchAllPersons();
                        System.out.println("ID\tFIRST_NAME\tLAST_NAME\tAGE");
                        for(Person p:list)
                        {
                            System.out.println(p);
                        }
                        break;
                    case 3:
                        System.out.println("Enter ID: ");
                        int id= scanner.nextInt();
                        Person p=personDao.findById(id);
                        if(p==null)
                        {
                            System.out.println("no such id found. ");
                        }
                        else
                        {
                            System.out.println("id found: "+p);
                        }
                        break;
                    case 4:
                        System.out.println("Enter ID: ");
                        id= scanner.nextInt();
                        personDao.deletePersonById(id);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("invalid choice.");
                        break;
                }

            }while (choice!=0);


        }
       catch (SQLException | InputMismatchException | ListEmptyException e)
       {
          System.err.println(e.getMessage());
       }

    }
}
