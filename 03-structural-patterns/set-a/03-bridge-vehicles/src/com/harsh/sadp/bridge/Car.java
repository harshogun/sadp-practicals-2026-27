
package com.harsh.sadp.bridge;

public class Car extends Vehicle {

    public Car(Workshop produce, Workshop assemble) {
        super(produce, assemble);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing Car:");
        produce.work();
        assemble.work();
        System.out.println("Car manufacturing completed.\n");
    }
}
