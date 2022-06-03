package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class App {

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String args[])
    {
        try {
            System.out.print("Enter Order Name: ");
            String name=scanner.nextLine();
            System.out.print("Enter Order Value: ");
            double value=scanner.nextDouble();
            Order order=new Order(UUID.randomUUID().toString(),name,value);
            System.out.println(order);

        }
        catch (InputMismatchException e)
        {
            System.out.println("please enter double value");
        }

    }
}
