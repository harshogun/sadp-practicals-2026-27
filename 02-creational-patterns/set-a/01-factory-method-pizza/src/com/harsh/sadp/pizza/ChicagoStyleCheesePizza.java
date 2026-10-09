package com.harsh.sadp.pizza;

public class ChicagoStyleCheesePizza extends CheesePizza {

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println(
                "Preparing " + name + " with thick crust and extra cheese");
    }

    @Override
    public void cut() {
        System.out.println("Cutting " + name + " into square slices");
    }
}
