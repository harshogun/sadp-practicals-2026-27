# Practical: Interface Segregation Principle (ISP)

## 1. Aim

To implement the Interface Segregation Principle (ISP) by dividing a large `Worker` interface into smaller, specific interfaces.

## 2. Problem Statement

A single `Worker` interface contains the following methods:

- `work()`
- `eat()`
- `sleep()`
- `get_paid()`

There are two types of workers: `HumanWorker` and `RobotWorker`.

A human worker can perform all four operations, whereas a robot worker can work and receive payment but cannot eat or sleep.

Refactor the design so that classes are not forced to implement methods they do not need.

## 3. Theory

The **Interface Segregation Principle (ISP)** is the fourth principle of SOLID. It states:

> Clients should not be forced to depend on methods they do not use.

Instead of creating one large interface, we create smaller interfaces based on specific responsibilities.

## 4. Class and Interface Design

| Interface / Class | Responsibility |
|---|---|
| `Workable` | Declares `work()` |
| `Feedable` | Declares `eat()` |
| `Restable` | Declares `sleep()` |
| `Payable` | Declares `get_paid()` |
| `HumanWorker` | Implements all four interfaces |
| `RobotWorker` | Implements only `Workable` and `Payable` |
| `Main` | Demonstrates both worker implementations |

## 5. Project Structure

```text
02-isp-worker/
├── README.md
└── src/
    └── com/
        └── harsh/
            └── sadp/
                └── worker/
                    ├── Workable.java
                    ├── Feedable.java
                    ├── Restable.java
                    ├── Payable.java
                    ├── HumanWorker.java
                    ├── RobotWorker.java
                    └── Main.java
```

## 6. Technologies Used

- Java
- Object-Oriented Programming
- SOLID Principles
- IntelliJ IDEA

## 7. How to Run

1. Open the project in IntelliJ IDEA or Eclipse.
2. Ensure all Java files use the package `com.harsh.sadp.worker`.
3. Open `Main.java`.
4. Run the `main()` method.
5. Verify the output in the console.

## 8. Expected Output

```text
--- Human Worker ---
Human is working.
Human is eating.
Human is sleeping.
Human receives payment.

--- Robot Worker ---
Robot is working.
Robot receives payment.
```

## 9. Advantages

- Avoids unnecessary method implementations.
- Promotes smaller, focused interfaces.
- Reduces coupling between classes and interfaces.
- Makes the system easier to maintain and extend.
- Allows human and robot workers to support different capabilities.

## 10. Viva Questions and Answers

**Q1. What is the Interface Segregation Principle?**

ISP states that clients should not be forced to depend on methods they do not use.

**Q2. Which SOLID principle does this practical demonstrate?**

It demonstrates the Interface Segregation Principle, the fourth SOLID principle.

**Q3. Why should `RobotWorker` not implement `Feedable` and `Restable`?**

A robot does not eat or sleep, so implementing these interfaces would force it to provide unnecessary methods.

**Q4. How does ISP improve maintainability?**

It keeps interfaces small and focused, so changes to one capability are less likely to affect unrelated classes.

**Q5. How is ISP different from SRP?**

SRP focuses on giving a class one reason to change. ISP focuses on preventing clients from depending on methods they do not need.

## 11. Conclusion

The Interface Segregation Principle was implemented successfully by separating worker behaviors into four independent interfaces. `HumanWorker` implements all four interfaces, while `RobotWorker` implements only `Workable` and `Payable`.

This demonstrates how interface segregation leads to a cleaner, more flexible, and maintainable design.