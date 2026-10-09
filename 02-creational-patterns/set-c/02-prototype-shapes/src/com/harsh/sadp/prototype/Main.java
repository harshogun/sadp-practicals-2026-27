
package com.harsh.sadp.prototype;

public class Main {

    public static void main(String[] args) {

        Circle originalCircle = new Circle(5.0);
        Shape clonedCircle = originalCircle.clone();

        Rectangle originalRectangle =
                new Rectangle(10.0, 4.0);
        Shape clonedRectangle = originalRectangle.clone();

        System.out.println("Original Circle:");
        originalCircle.display();

        System.out.println("Cloned Circle:");
        clonedCircle.display();

        System.out.println("\nOriginal Rectangle:");
        originalRectangle.display();

        System.out.println("Cloned Rectangle:");
        clonedRectangle.display();

        System.out.println(
                "\nCircle objects are different: "
                        + (originalCircle != clonedCircle)
        );

        System.out.println(
                "Rectangle objects are different: "
                        + (originalRectangle != clonedRectangle)
        );
    }
}
