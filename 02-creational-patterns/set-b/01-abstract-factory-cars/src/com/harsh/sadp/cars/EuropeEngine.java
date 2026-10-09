
package com.harsh.sadp.cars;

public class EuropeEngine implements Engine {

    @Override
    public void displayEngineSpecifications() {
        System.out.println("Engine: European specification");
        System.out.println("Fuel economy: Litres per 100 kilometres (L/100 km)");
    }
}
