package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyApp {

    private static Scanner scanner=new Scanner(System.in);
    public static void main(String args[])
    {
        try {
            System.out.println("Enter First Name: ");
            String firstName=scanner.next();
            System.out.println("Enter Lasst Name: ");
            String lastName=scanner.next();
            System.out.println("Enter Salary: ");
            double salary=scanner.nextDouble();
            if(salary<10000)
            {
                throw new InvalidSalaryException("salary must be at-least 10000");
            }
            Employee employee=new Employee(1,firstName,lastName,salary);
            System.out.println(employee);


        }
        catch (InputMismatchException | InvalidSalaryException e)
        {
           System.out.println(e.toString());
        }


    }
}
