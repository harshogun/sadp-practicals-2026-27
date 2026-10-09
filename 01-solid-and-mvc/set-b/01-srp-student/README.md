# Practical: Single Responsibility Principle (SRP)

## Aim
To refactor student management logic according to the Single Responsibility Principle.

## Problem Statement
Separate student data storage, grade calculation, and file persistence into independent classes.

## Concept
The Single Responsibility Principle states that a class should have only one reason to change.

## Class Responsibilities
- `Student`: Stores student name and marks.
- `GradeCalculator`: Calculates the average and grade.
- `StudentRepository`: Saves student results to a text file.
- `Main`: Coordinates execution.

## Prerequisites
- Java Development Kit (JDK)
- IntelliJ IDEA or Eclipse

## How to Run
1. Open the project in your IDE.
2. Run `Main.java`.
3. Inspect the console output.
4. Verify the generated `data/students.txt` file.

## Sample Output
Average: 85.00  
Grade: B

## Conclusion
The implementation separates student data, grading logic, and persistence into distinct classes, making the program easier to maintain and extend.