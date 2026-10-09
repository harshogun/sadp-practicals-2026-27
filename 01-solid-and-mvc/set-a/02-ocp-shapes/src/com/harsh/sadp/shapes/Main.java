package com.harsh.sadp.shapes;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);
        Shape triangle = new Triangle(6, 3);

        System.out.printf("Circle area: %.2f%n",
                circle.calculateArea());

        System.out.printf("Square area: %.2f%n",
                square.calculateArea());

        System.out.printf("Triangle area: %.2f%n",
                triangle.calculateArea());
    }
}