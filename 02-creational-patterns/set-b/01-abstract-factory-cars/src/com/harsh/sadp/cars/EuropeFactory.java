
package com.harsh.sadp.cars;

public class EuropeFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new EuropeCar();
    }

    @Override
    public Engine createEngine() {
        return new EuropeEngine();
    }
}
