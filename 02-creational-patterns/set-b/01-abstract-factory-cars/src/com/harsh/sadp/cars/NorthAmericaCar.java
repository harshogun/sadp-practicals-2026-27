
package com.harsh.sadp.cars;

public class NorthAmericaCar implements Car {

    @Override
    public void displaySpecifications() {
        System.out.println("Region: North America");
        System.out.println("Steering: Left-hand drive");
        System.out.println("Speed display: Miles per hour (mph)");
    }
}
