
package com.harsh.sadp.pizza;

public class ChicagoPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza() {
        return new ChicagoStyleCheesePizza();
    }
}
