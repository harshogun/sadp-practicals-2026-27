# Practical: Open/Closed Principle Using Shapes

## Aim
To implement the Open/Closed Principle using a common Shape interface and concrete shape classes.

## Concept
The Open/Closed Principle states that software entities should be open for extension but closed for modification.

## Classes
- `Shape`: Defines the `calculateArea()` contract.
- `Circle`: Calculates the area of a circle.
- `Square`: Calculates the area of a square.
- `Triangle`: Calculates the area of a triangle.
- `Main`: Demonstrates polymorphism.

## How to Run
Compile the Java files and run `Main` from Eclipse or the terminal.

## Expected Output
- Circle area: 78.54
- Square area: 16.00
- Triangle area: 9.00

## Conclusion
New shapes can be added by implementing the Shape interface without changing existing shape implementations.