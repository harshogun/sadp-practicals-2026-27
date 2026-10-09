
package com.harsh.sadp.pizzaDecorator;

public class Mushrooms extends PizzaDecorator {

    public Mushrooms(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Mushrooms";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.00;
    }
}
