package com.harsh.sadp.orders;

public class Order {

    private final String orderId;
    private final String customerEmail;
    private final String type;
    private final double amount;

    public Order(
            String orderId,
            String customerEmail,
            String type,
            double amount) {

        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.type = type;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
