# Singleton Pattern for Multithreading

## Aim
To implement the Singleton Design Pattern in Java and verify that multiple threads access the same instance.

## Theory
The Singleton Pattern ensures that a class has only one instance and provides a global access point to it.

This implementation uses the **Initialization-on-demand Holder idiom**. The nested `Holder` class initializes the singleton when `getInstance()` is first called. Java class initialization guarantees thread-safe initialization.

## Algorithm
1. Create a class with a private constructor.
2. Define a private static nested `Holder` class.
3. Store a single instance inside `Holder`.
4. Provide a public static `getInstance()` method.
5. Create multiple threads that request the singleton instance.
6. Print each instance's identity hash code and verify that it is the same.

## Advantages
- Ensures a single instance.
- Supports thread-safe initialization.
- Provides lazy initialization.
- Avoids explicit synchronization in `getInstance()`.

## Conclusion
The Singleton Pattern was implemented using the Holder idiom. Multiple threads accessed the same instance, demonstrating thread-safe singleton initialization.