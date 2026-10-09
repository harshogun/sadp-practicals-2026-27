
package com.harsh.sadp.prototype;

public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public Shape clone() {
        return new Circle(this.radius);
    }

    @Override
    public void display() {
        System.out.println("Circle radius: " + radius);
    }
}
