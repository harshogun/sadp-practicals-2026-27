package com.harsh.sadp.orders;

public class DigitalOrderStrategy implements OrderStrategy {

    @Override
    public String getType() {
        return "digital";
    }

    @Override
    public double getDiscountRate() {
        return 0.10;
    }
}
