package com.harsh.sadp.shapes;

public class Square implements Shape {
    private final double side;

    public Square(double side) {
        if (side < 0) {
            throw new IllegalArgumentException(
                    "Side cannot be negative");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}