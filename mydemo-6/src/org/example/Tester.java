package org.example;

import java.util.Scanner;

public class Tester {

    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args)
    {
        int choice=0;
        System.out.print("Enter Length: ");
        int length=scanner.nextInt();
        OrderFactory orderFactory=new OrderFactoryImpl(length);
        do {
            System.out.println("1. Create Orders. ");
            System.out.println("2. Display All Orders..");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice: ");
            choice= scanner.nextInt();
            switch (choice)
            {
                case 1:

                        Order[] orders= orderFactory.createOrders();
                        System.out.println("orders are created sucessfully");
                   break;
                case 2:
                    orderFactory.fetchOrders();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice..");
                    break;

            }

        }while (choice!=0);
        }
}
