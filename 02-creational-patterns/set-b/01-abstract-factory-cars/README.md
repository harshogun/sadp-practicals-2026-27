# Practical: Abstract Factory Design Pattern — Regional Cars

## Aim

To implement the Abstract Factory Design Pattern in Java to create cars and associated engine specifications for North America and Europe.

## Problem Statement

Different markets may require different vehicle configurations and specifications. The application should create a compatible family of products for each region without coupling the client to concrete implementation classes.

## Theory

The Abstract Factory Design Pattern provides an interface for creating families of related objects without specifying their concrete classes.

In this practical, each regional factory creates a car and its associated engine configuration.

## Class Responsibilities

| Class / Interface | Responsibility |
|---|---|
| `Car` | Defines the car specification operation |
| `Engine` | Defines the engine specification operation |
| `CarFactory` | Declares methods for creating cars and engines |
| `NorthAmericaCar` | Implements the North American car configuration |
| `NorthAmericaEngine` | Implements the North American engine configuration |
| `EuropeCar` | Implements the European car configuration |
| `EuropeEngine` | Implements the European engine configuration |
| `NorthAmericaFactory` | Creates the North American product family |
| `EuropeFactory` | Creates the European product family |
| `Main` | Demonstrates both regional factories |

## Workflow

1. The client selects a regional factory.
2. The factory creates a car and engine implementation for that region.
3. The client calls the specification methods through interfaces.
4. The same client workflow works with either regional factory.

## Technologies Used

- Java
- Interfaces and Polymorphism
- Abstract Factory Design Pattern
- IntelliJ IDEA

## Expected Result

The program displays the car and engine specifications for North America and Europe.

## Advantages

- Separates product creation from client logic.
- Groups related products into compatible families.
- Reduces dependencies on concrete classes.
- Makes additional regional configurations easier to introduce.

## Viva Questions

**1. What is the Abstract Factory pattern?**

It provides an interface for creating families of related objects without specifying their concrete classes.

**2. What is a product family in this example?**

The car and engine implementations created for a particular region.

**3. Why does `CarFactory` return interfaces?**

It allows clients to use different concrete implementations through common abstractions.

**4. How does this differ from Factory Method?**

Factory Method delegates creation of a product to a creator subclass. Abstract Factory provides a group of creation methods for related products.

**5. How can a new region be added?**

Create the new region's car and engine implementations and a factory implementing `CarFactory`.

## Conclusion

The Abstract Factory Design Pattern was demonstrated by creating regional car and engine product families. The design separates object creation from client logic and supports extension through new factory implementations.