
package com.harsh.sadp.cars;

public class NorthAmericaEngine implements Engine {

    @Override
    public void displayEngineSpecifications() {
        System.out.println("Engine: North American specification");
        System.out.println("Fuel economy: Miles per gallon (mpg)");
    }
}
