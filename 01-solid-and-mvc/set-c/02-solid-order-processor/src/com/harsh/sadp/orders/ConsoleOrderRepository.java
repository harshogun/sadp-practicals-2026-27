package com.harsh.sadp.orders;

public class ConsoleOrderRepository implements OrderRepository {

    @Override
    public void save(Order order, double total) {
        System.out.printf(
                "Order %s saved. Total: %.2f%n",
                order.getOrderId(),
                total
        );
    }
}
