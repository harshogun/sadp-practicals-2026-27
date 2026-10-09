# Singleton LoggerService

## Aim
To implement the Singleton Design Pattern using a `LoggerService` class.

## Theory
The Singleton Pattern ensures that only one instance of a class is created and provides a global access point to it.

## Implementation
- The constructor is private to prevent external object creation.
- A private static field stores the single instance.
- The public static `getInstance()` method provides access to that instance.
- The `log()` method prints timestamped log messages.

## Conclusion
The Singleton LoggerService was implemented successfully. Both references access the same object, as verified by the `Same instance: true` output.