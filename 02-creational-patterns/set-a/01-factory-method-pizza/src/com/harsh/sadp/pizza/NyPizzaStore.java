
package com.harsh.sadp.pizza;

public class NyPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza() {
        return new NyStyleCheesePizza();
    }
}
