# Practical: Abstract Factory Design Pattern — Mobile Functionalities

## Aim

To implement the Abstract Factory Design Pattern in Java for creating related mobile functionalities, including taking photos and recording videos.

## Problem Statement

Different mobile brands provide camera and video-recording functionalities. The application should create compatible products for each brand without coupling the client to concrete product classes.

## Theory

The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating families of related objects without specifying their concrete classes.

## Class Responsibilities

| Class / Interface | Responsibility |
|---|---|
| `Camera` | Defines the `takePhoto()` operation |
| `VideoRecorder` | Defines the `recordVideo()` operation |
| `MobileFactory` | Defines factory methods for both products |
| `BrandACamera` | Implements Brand A photo functionality |
| `BrandAVideoRecorder` | Implements Brand A video functionality |
| `BrandBCamera` | Implements Brand B photo functionality |
| `BrandBVideoRecorder` | Implements Brand B video functionality |
| `BrandAFactory` | Creates Brand A products |
| `BrandBFactory` | Creates Brand B products |
| `Main` | Demonstrates both factories through a common client |

## Design Pattern Workflow

1. The client selects a concrete factory.
2. The factory creates a camera and video recorder belonging to the same brand.
3. The client invokes operations through the product interfaces.
4. The client remains independent of the concrete product classes.

## Technologies Used

- Java
- Interfaces and Polymorphism
- Abstract Factory Design Pattern
- IntelliJ IDEA

## Expected Output

```text
--- Brand A ---
Brand A Taking Photo!
Brand A Recording a Video!

--- Brand B ---
Brand B is taking a photo.
Brand B is recording a video.
```

## Advantages

- Separates product creation from client logic.
- Keeps related products from the same brand together.
- Reduces coupling to concrete implementations.
- Makes it easier to add another brand by introducing a new factory and product implementations.

## Viva Questions

**1. What is the Abstract Factory Design Pattern?**

It provides an interface for creating families of related objects without specifying their concrete classes.

**2. Why are there two product interfaces?**

Camera and video recording represent separate functionalities that can have different implementations.

**3. What is the responsibility of `MobileFactory`?**

It declares factory methods for creating a camera and a video recorder.

**4. How does this differ from Factory Method?**

Factory Method typically delegates creation of one product type to creator subclasses. Abstract Factory provides methods for creating a family of related products.

**5. Why does `Main` use interfaces?**

It allows the client to operate on different implementations without depending directly on concrete classes.

**6. How can a new mobile brand be added?**

Create its camera and video-recorder implementations and a factory implementing `MobileFactory`, without changing the common client workflow.

## Conclusion

The Abstract Factory Design Pattern was demonstrated by creating camera and video-recorder products for two mobile brands. The client uses common interfaces to interact with each product family, reducing coupling and improving extensibility.