
package com.harsh.sadp.prototype;

public class Rectangle implements Shape {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public Shape clone() {
        return new Rectangle(this.length, this.width);
    }

    @Override
    public void display() {
        System.out.println(
                "Rectangle length: " + length
                        + ", width: " + width
        );
    }
}
