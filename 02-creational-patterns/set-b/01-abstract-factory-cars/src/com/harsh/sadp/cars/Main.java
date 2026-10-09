
package com.harsh.sadp.cars;

public class Main {

    private static void showSpecifications(
            CarFactory factory) {

        Car car = factory.createCar();
        Engine engine = factory.createEngine();

        car.displaySpecifications();
        engine.displayEngineSpecifications();
    }

    public static void main(String[] args) {

        System.out.println("=== North America ===");
        showSpecifications(new NorthAmericaFactory());

        System.out.println();

        System.out.println("=== Europe ===");
        showSpecifications(new EuropeFactory());
    }
}
