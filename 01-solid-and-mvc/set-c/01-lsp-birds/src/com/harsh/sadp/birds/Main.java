package com.harsh.sadp.birds;

public class Main {

    public static void makeFly(FlyingBird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        Penguin penguin = new Penguin();

        sparrow.eat();
        makeFly(sparrow);

        penguin.eat();
        penguin.swim();
    }
}