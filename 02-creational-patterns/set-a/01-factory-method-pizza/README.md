# Practical: Factory Method Design Pattern — Pizza Store

## 1. Aim

To implement the Factory Method Design Pattern in Java by creating a pizza store that produces different styles of cheese pizza while maintaining a common ordering workflow.

## 2. Problem Statement

A pizza store offers different types of pizza, such as New York-style cheese pizza and Chicago-style cheese pizza.

Each pizza has its own preparation requirements, but the overall ordering process remains the same.

The Factory Method Design Pattern separates object creation from the ordering workflow by allowing subclasses to decide which concrete pizza object to create.

## 3. Theory

The **Factory Method Design Pattern** is a creational design pattern that defines a method for creating objects while allowing subclasses to determine the concrete class to instantiate.

In this practical:

- `PizzaStore` defines the common ordering workflow.
- `createPizza()` is the factory method.
- `NyPizzaStore` creates New York-style cheese pizza.
- `ChicagoPizzaStore` creates Chicago-style cheese pizza.
- `Pizza` provides the common abstraction for all pizzas.

The ordering workflow remains consistent even when new pizza styles are introduced.

## 4. Class Responsibilities

| Class | Responsibility |
|---|---|
| `Pizza` | Defines common pizza operations |
| `CheesePizza` | Provides the common cheese-pizza implementation |
| `NyStyleCheesePizza` | Represents New York-style cheese pizza |
| `ChicagoStyleCheesePizza` | Represents Chicago-style cheese pizza |
| `PizzaStore` | Defines `orderPizza()` and the abstract `createPizza()` method |
| `NyPizzaStore` | Creates New York-style cheese pizza |
| `ChicagoPizzaStore` | Creates Chicago-style cheese pizza |
| `Main` | Demonstrates ordering pizza from both stores |

## 5. Project Structure

```text
01-factory-method-pizza/
├── README.md
└── src/
    └── com/
        └── harsh/
            └── sadp/
                └── pizza/
                    ├── Pizza.java
                    ├── CheesePizza.java
                    ├── NyStyleCheesePizza.java
                    ├── ChicagoStyleCheesePizza.java
                    ├── PizzaStore.java
                    ├── NyPizzaStore.java
                    ├── ChicagoPizzaStore.java
                    └── Main.java
```

## 6. Technologies Used

- Java
- Object-Oriented Programming
- Abstract Classes and Inheritance
- Polymorphism
- Factory Method Design Pattern
- IntelliJ IDEA

## 7. Workflow

1. `Main` creates a `NyPizzaStore` or `ChicagoPizzaStore`.
2. The client calls `orderPizza()`.
3. `orderPizza()` invokes the factory method `createPizza()`.
4. The appropriate store subclass creates the concrete pizza.
5. The pizza is prepared, baked, cut, and boxed.
6. The completed pizza is returned to the client.

## 8. Expected Output

```text
--- New York Pizza Store ---
Preparing New York Style Cheese Pizza with thin crust and marinara sauce
Baking New York Style Cheese Pizza
Cutting New York Style Cheese Pizza
Boxing New York Style Cheese Pizza
Ordered: New York Style Cheese Pizza

--- Chicago Pizza Store ---
Preparing Chicago Style Cheese Pizza with thick crust and extra cheese
Baking Chicago Style Cheese Pizza
Cutting Chicago Style Cheese Pizza into square slices
Boxing Chicago Style Cheese Pizza
Ordered: Chicago Style Cheese Pizza
```

## 9. Advantages

- Separates object creation from the ordering workflow.
- Allows subclasses to create different concrete objects.
- Reduces dependence on concrete pizza classes in the common workflow.
- Supports extension with additional pizza-store implementations.
- Demonstrates polymorphism and the Open/Closed Principle.

## 10. Viva Questions and Answers

**Q1. What is the Factory Method Design Pattern?**

It is a creational design pattern that lets subclasses determine which concrete object is created through a factory method.

**Q2. Why is `createPizza()` abstract in `PizzaStore`?**

Different stores need to create different pizza types. Making the method abstract requires each concrete store to define its own creation behavior.

**Q3. What is the responsibility of `orderPizza()`?**

It defines the common workflow of creating, preparing, baking, cutting, and boxing a pizza.

**Q4. Why does `orderPizza()` return a `Pizza` instead of a concrete pizza class?**

Returning the common abstraction allows the method to work with different pizza implementations through polymorphism.

**Q5. What is the difference between a factory method and a simple factory?**

A simple factory commonly centralizes object creation in one method, often using conditional statements. Factory Method uses inheritance and overriding to let creator subclasses determine which concrete product is created.

**Q6. How does this design demonstrate the Open/Closed Principle?**

A new store and pizza implementation can be added without changing the existing `orderPizza()` workflow.

**Q7. What is the Hollywood Principle?**

It is commonly expressed as “Don't call us, we'll call you.” In this design, the store's ordering workflow invokes the overridden factory method rather than the client directly controlling object creation.

**Q8. Why is polymorphism useful here?**

It allows the common workflow to operate on the `Pizza` abstraction while the actual behavior depends on the concrete pizza object.

## 11. Conclusion

The Factory Method Design Pattern was implemented successfully by separating pizza creation from the common ordering workflow. Different store subclasses create different pizza styles while reusing the same ordering algorithm.

This design improves extensibility, reduces coupling to concrete product classes, and demonstrates inheritance and polymorphism in Java.