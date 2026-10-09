# Practical: Refactoring OrderProcessor Using SOLID Principles

## 1. Aim

To refactor an `OrderProcessor` application using all five SOLID principles to improve modularity, maintainability, extensibility, and testability.

## 2. Problem Statement

An order-processing system may perform multiple operations, including order validation, price calculation, discount and tax calculation, persistence, email confirmation, and logging.

Combining all these operations in a single class makes the system difficult to maintain and extend.

The objective is to separate these responsibilities and use abstractions so that changes in one component do not unnecessarily affect others.

## 3. Theory: SOLID Principles

### S — Single Responsibility Principle (SRP)

A class should have only one reason to change.

In this implementation:
- `OrderValidator` validates orders.
- `PriceCalculator` calculates discounts, taxes, and totals.
- `ConsoleOrderRepository` demonstrates order persistence.
- `ConsoleEmailNotifier` demonstrates confirmation notifications.
- `ConsoleOrderLogger` handles processing logs.

### O — Open/Closed Principle (OCP)

Software entities should be open for extension but closed for modification.

The `OrderStrategy` interface allows new order strategies to be introduced without adding order-type conditionals to `PriceCalculator`.

### L — Liskov Substitution Principle (LSP)

Implementations of an abstraction should be usable interchangeably without breaking the expected behavior.

`DigitalOrderStrategy` and `PhysicalOrderStrategy` implement the same `OrderStrategy` contract. Each provides an order type and discount rate.

### I — Interface Segregation Principle (ISP)

Clients should not be forced to depend on methods they do not use.

The application uses focused interfaces:
- `OrderRepository`
- `EmailNotifier`
- `OrderLogger`

Each interface represents a separate operation.

### D — Dependency Inversion Principle (DIP)

High-level modules should depend on abstractions rather than concrete implementations.

`OrderProcessor` receives its validator, price calculator, repository, notifier, and logger through constructor injection.

## 4. Class Responsibilities

| Class / Interface | Responsibility |
|---|---|
| `Order` | Stores order ID, customer email, order type, and amount |
| `OrderValidator` | Validates order data |
| `PriceCalculator` | Calculates discounts, tax, and final total |
| `OrderStrategy` | Defines the order type and discount-rate contract |
| `DigitalOrderStrategy` | Supplies the digital-order discount rate |
| `PhysicalOrderStrategy` | Supplies the physical-order discount rate |
| `OrderRepository` | Defines the order-saving contract |
| `ConsoleOrderRepository` | Demonstrates saving an order through console output |
| `EmailNotifier` | Defines the confirmation-notification contract |
| `ConsoleEmailNotifier` | Demonstrates sending a confirmation through console output |
| `OrderLogger` | Defines the logging contract |
| `ConsoleOrderLogger` | Prints processing log messages |
| `OrderProcessor` | Coordinates validation, pricing, saving, notification, and logging |
| `Main` | Creates dependencies and demonstrates execution |

## 5. Project Structure

```text
02-solid-order-processor/
├── README.md
└── src/
    └── com/
        └── harsh/
            └── sadp/
                └── orders/
                    ├── Order.java
                    ├── OrderValidator.java
                    ├── PriceCalculator.java
                    ├── OrderStrategy.java
                    ├── DigitalOrderStrategy.java
                    ├── PhysicalOrderStrategy.java
                    ├── OrderRepository.java
                    ├── ConsoleOrderRepository.java
                    ├── EmailNotifier.java
                    ├── ConsoleEmailNotifier.java
                    ├── OrderLogger.java
                    ├── ConsoleOrderLogger.java
                    ├── OrderProcessor.java
                    └── Main.java
```

## 6. Technologies Used

- Java
- Object-Oriented Programming
- Interfaces and Polymorphism
- SOLID Design Principles
- Constructor Dependency Injection
- IntelliJ IDEA

## 7. Pricing Policy Used in This Demonstration

The following rates are illustrative assumptions for this implementation:

- Digital orders receive a 10% discount.
- Physical orders receive no discount.
- Tax is 18% of the discounted amount.

For a digital order with a subtotal of 1,000:

| Calculation | Amount |
|---|---:|
| Subtotal | 1,000.00 |
| Discount (10%) | -100.00 |
| Taxable amount | 900.00 |
| Tax (18%) | 162.00 |
| **Final total** | **1,062.00** |

For a physical order with a subtotal of 1,000, the final total is 1,180.00.

These rates are demonstration values and can be changed according to the actual requirements.

## 8. How to Run

1. Open the project in IntelliJ IDEA or Eclipse.
2. Ensure all Java files use the package `com.harsh.sadp.orders`.
3. Open `Main.java`.
4. Run the `main()` method.
5. Inspect the console output for order processing, confirmation, and logging messages.

The demonstration uses console-based implementations. It does not connect to a real database or email service.

## 9. Sample Output

For a digital order with ID `ORD-101` and subtotal `1000.00`:

```text
Order ORD-101 saved. Total: 1062.00
Confirmation sent to customer@example.com for order ORD-101. Total: 1062.00
[LOG] Processed order ORD-101
```

For a physical order with ID `ORD-102` and subtotal `1000.00`:

```text
Order ORD-102 saved. Total: 1180.00
Confirmation sent to customer@example.com for order ORD-102. Total: 1180.00
[LOG] Processed order ORD-102
```

For an invalid order with a negative amount:

```text
Invalid order rejected: Order amount must be positive and finite
```

For a digital order paired with a physical strategy:

```text
Order rejected: Order type does not match strategy
```

## 10. Testing Checklist

- [ ] Valid digital order produces the expected total.
- [ ] Valid physical order produces the expected total.
- [ ] An order with a negative amount is rejected.
- [ ] An order with a blank ID is rejected.
- [ ] A mismatched order type and strategy are rejected.
- [ ] Invalid orders are handled using exception handling.
- [ ] The processor uses constructor-injected dependencies.
- [ ] Both strategy implementations satisfy the common interface.

Mark a test as complete only after running it and verifying the result.

## 11. Viva Questions and Answers

**Q1. What are the five SOLID principles?**

SRP: Single Responsibility Principle; OCP: Open/Closed Principle; LSP: Liskov Substitution Principle; ISP: Interface Segregation Principle; DIP: Dependency Inversion Principle.

**Q2. Why was `OrderProcessor` refactored?**

To separate responsibilities, reduce coupling, and make the system easier to maintain, test, and extend.

**Q3. How does SRP apply to this program?**

Validation, pricing, persistence, notification, and logging are handled by separate components.

**Q4. How does OCP apply to `PriceCalculator`?**

New order strategies can provide different discount rates without adding order-type conditionals to the calculator.

**Q5. How does LSP apply to the strategy classes?**

Both digital and physical strategies implement the same contract and can be supplied to the processor. Their behavior must continue to satisfy that contract.

**Q6. How does ISP apply to this design?**

The repository, notification, and logging interfaces expose focused operations rather than one large interface containing unrelated methods.

**Q7. What is Dependency Injection?**

Dependency Injection is a technique in which an object's dependencies are supplied from outside instead of being constructed internally by that object.

**Q8. Why use constructor injection?**

It makes dependencies explicit and allows different implementations to be supplied for testing or future changes.

**Q9. Does the repository implementation save data to a real database?**

No. `ConsoleOrderRepository` prints a message to demonstrate the persistence contract. A database implementation would need to be added separately.

**Q10. How could this application be improved for production?**

Use `BigDecimal` for monetary calculations, stronger input validation, real persistence, a real notification service, structured logging, and automated unit tests.

## 12. Conclusion

The `OrderProcessor` application demonstrates how the five SOLID principles can be applied together. Separating responsibilities, introducing focused interfaces, using order strategies, and injecting dependencies produces a more modular and extensible design.