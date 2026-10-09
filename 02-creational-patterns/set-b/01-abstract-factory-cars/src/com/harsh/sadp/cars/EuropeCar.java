
package com.harsh.sadp.cars;

public class EuropeCar implements Car {

    @Override
    public void displaySpecifications() {
        System.out.println("Region: Europe");
        System.out.println("Steering: Left-hand drive (typical configuration)");
        System.out.println("Speed display: Kilometres per hour (km/h)");
    }
}
