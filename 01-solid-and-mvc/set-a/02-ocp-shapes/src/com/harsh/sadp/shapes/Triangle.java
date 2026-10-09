package com.harsh.sadp.shapes;

public class Triangle implements Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException(
                    "Dimensions cannot be negative");
        }
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}