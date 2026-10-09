
package com.harsh.sadp.cars;

public class NorthAmericaFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new NorthAmericaCar();
    }

    @Override
    public Engine createEngine() {
        return new NorthAmericaEngine();
    }
}
