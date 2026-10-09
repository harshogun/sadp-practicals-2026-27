package com.harsh.sadp.orders;

public class PhysicalOrderStrategy implements OrderStrategy {

    @Override
    public String getType() {
        return "physical";
    }

    @Override
    public double getDiscountRate() {
        return 0.0;
    }
}
