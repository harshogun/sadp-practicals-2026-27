
package com.harsh.sadp.pizzaDecorator;

public class Olives extends PizzaDecorator {

    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 25.00;
    }
}
