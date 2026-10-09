
package com.harsh.sadp.proxy;

public class Main {

    public static void main(String[] args) {

        Image image = new ProxyImage("landscape.jpg");

        System.out.println("Image proxy created.");
        System.out.println("First display:");
        image.display();

        System.out.println("\nSecond display:");
        image.display();
    }
}
