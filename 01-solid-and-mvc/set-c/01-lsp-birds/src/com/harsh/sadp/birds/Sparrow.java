package com.harsh.sadp.birds;

public class Sparrow extends Bird implements FlyingBird {

    @Override
    public void eat() {
        System.out.println("Sparrow is eating.");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying.");
    }
}