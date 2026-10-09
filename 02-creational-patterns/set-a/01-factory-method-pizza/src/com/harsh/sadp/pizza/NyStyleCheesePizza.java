package com.harsh.sadp.pizza;

public class NyStyleCheesePizza extends CheesePizza {

    public NyStyleCheesePizza() {
        name = "New York Style Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println(
                "Preparing " + name + " with thin crust and marinara sauce");
    }
}
