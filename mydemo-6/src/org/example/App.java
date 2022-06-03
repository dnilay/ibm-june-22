package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.UUID;

public class App {

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String args[])
    {
    Order order=null;
    String name=null;
    double value=0;


        try {
            System.out.print("Enter Order Name: ");
            name=scanner.nextLine();
            System.out.print("Enter Order Value: ");
            value=scanner.nextDouble();
            System.out.println(order.toString());

        }
        catch (InputMismatchException e)
        {
            System.out.println("please enter double value"+e.toString());
        }
        catch (NullPointerException np)
        {
            System.out.println("order is null"+ np.toString());
        }
     //   order=new Order(UUID.randomUUID().toString(),name,value);



    }
}
