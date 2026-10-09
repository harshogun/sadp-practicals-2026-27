
package com.harsh.sadp.pizzaDecorator;

public class Main {

    public static void main(String[] args) {

        Pizza pizza = new PlainPizza();

        System.out.printf(
                "Order: %s%nCost: Rs. %.2f%n%n",
                pizza.getDescription(),
                pizza.getCost()
        );

        pizza = new Cheese(pizza);
        pizza = new Olives(pizza);
        pizza = new Mushrooms(pizza);

        System.out.printf(
                "Order: %s%nCost: Rs. %.2f%n",
                pizza.getDescription(),
                pizza.getCost()
        );
    }
}
