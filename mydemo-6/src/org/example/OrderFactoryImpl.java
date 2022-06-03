package org.example;

import java.util.Scanner;
import java.util.UUID;

public class OrderFactoryImpl implements OrderFactory{
    private Order[] orders;
    private static Scanner scanner=new Scanner(System.in);
    private int length=0;
    private String name;
    private double value;

    public OrderFactoryImpl(int length) {
        this.length=length;
    //    orders=new Order[this.length];
    }

    @Override
    public Order[] createOrders() throws ArrayIndexOutOfBoundsException, NullPointerException {

        for(int i=0;i<orders.length;i++)
        {
            System.out.print("Enter Order Name: ");
            name=scanner.next();
            System.out.print("Enter Order Value: ");
            value=scanner.nextDouble();
            orders[i]=new Order(UUID.randomUUID().toString(),name,value);
        }
        return orders;
    }

    @Override
    public void fetchOrders() throws ArrayIndexOutOfBoundsException, NullPointerException {
        for(Order o:orders)
        {
            System.out.println(o);
        }
    }
}
