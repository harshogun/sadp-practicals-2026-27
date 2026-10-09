package com.harsh.sadp.orders;

public class ConsoleEmailNotifier implements EmailNotifier {

    @Override
    public void sendConfirmation(Order order, double total) {
        System.out.printf(
                "Confirmation sent to %s for order %s. Total: %.2f%n",
                order.getCustomerEmail(),
                order.getOrderId(),
                total
        );
    }
}
