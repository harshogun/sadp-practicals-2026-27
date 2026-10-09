package com.harsh.sadp.birds;

public class Penguin extends Bird {

    @Override
    public void eat() {
        System.out.println("Penguin is eating.");
    }

    public void swim() {
        System.out.println("Penguin is swimming.");
    }
}