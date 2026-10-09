
package com.harsh.sadp.bridge;

public class Bike extends Vehicle {

    public Bike(Workshop produce, Workshop assemble) {
        super(produce, assemble);
    }

    @Override
    public void manufacture() {
        System.out.println("Manufacturing Bike:");
        produce.work();
        assemble.work();
        System.out.println("Bike manufacturing completed.\n");
    }
}
