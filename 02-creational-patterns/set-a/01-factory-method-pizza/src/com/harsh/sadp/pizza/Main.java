
package com.harsh.sadp.pizza;

public class Main {

    public static void main(String[] args) {

        PizzaStore nyStore = new NyPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        System.out.println("--- New York Pizza Store ---");
        Pizza nyPizza = nyStore.orderPizza();
        System.out.println("Ordered: " + nyPizza.getName());

        System.out.println();

        System.out.println("--- Chicago Pizza Store ---");
        Pizza chicagoPizza = chicagoStore.orderPizza();
        System.out.println("Ordered: " + chicagoPizza.getName());
    }
}
