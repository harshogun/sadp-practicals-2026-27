package com.harsh.sadp.orders;

public class PriceCalculator {

    private static final double TAX_RATE = 0.18;

    public double calculateTotal(
            Order order,
            OrderStrategy strategy) {

        double subtotal = order.getAmount();

        double discount =
                subtotal * strategy.getDiscountRate();

        double discountedAmount = subtotal - discount;

        double tax = discountedAmount * TAX_RATE;

        return discountedAmount + tax;
    }
}
