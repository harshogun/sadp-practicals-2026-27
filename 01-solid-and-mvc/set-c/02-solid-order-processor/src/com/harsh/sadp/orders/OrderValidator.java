package com.harsh.sadp.orders;

public class OrderValidator {

    public void validate(Order order) {
        if (order == null) {
            throw new IllegalArgumentException(
                    "Order cannot be null");
        }

        if (order.getOrderId() == null
                || order.getOrderId().isBlank()) {
            throw new IllegalArgumentException(
                    "Order ID cannot be empty");
        }

        if (order.getCustomerEmail() == null
                || !order.getCustomerEmail().contains("@")) {
            throw new IllegalArgumentException(
                    "A valid customer email is required");
        }

        if (order.getAmount() <= 0
                || !Double.isFinite(order.getAmount())) {
            throw new IllegalArgumentException(
                    "Order amount must be positive and finite");
        }

        if (order.getType() == null
                || order.getType().isBlank()) {
            throw new IllegalArgumentException(
                    "Order type cannot be empty");
        }
    }
}
