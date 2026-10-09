
package com.harsh.sadp.bridge;

public abstract class Vehicle {

    protected Workshop produce;
    protected Workshop assemble;

    public Vehicle(Workshop produce, Workshop assemble) {
        this.produce = produce;
        this.assemble = assemble;
    }

    public abstract void manufacture();
}
