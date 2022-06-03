package org.example;

public interface OrderFactory {

    public Order[] createOrders() throws ArrayIndexOutOfBoundsException,NullPointerException;
    public void fetchOrders()throws ArrayIndexOutOfBoundsException,NullPointerException;
}
