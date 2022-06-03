package org.example;

public class Order {

    private String orderId;
    private String orderName;
    private double orderValue;

    public Order() {
    }

    public Order(String orderId, String orderName, double orderValue) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderValue = orderValue;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(double orderValue) {
        this.orderValue = orderValue;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderValue=" + orderValue +
                '}';
    }
}
