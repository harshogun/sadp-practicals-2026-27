# Pizza Decorator Pattern

## Aim
To implement the Decorator Design Pattern by adding cheese, olives, and mushrooms to a basic pizza.

## Theory
The Decorator Pattern adds functionality to an object dynamically by wrapping it with decorator objects that implement the same interface.

## Implementation
- `Pizza` defines the common interface.
- `PlainPizza` provides the base pizza.
- `PizzaDecorator` is the abstract base decorator.
- `Cheese`, `Olives`, and `Mushrooms` add toppings and their respective costs.
- `Main` combines decorators to create a customized pizza.

## Conclusion
The Decorator Pattern was implemented successfully. Toppings can be added dynamically without modifying the original `PlainPizza` class.