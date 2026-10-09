# Practical: Liskov Substitution Principle (LSP)

## 1. Aim

To demonstrate the Liskov Substitution Principle using a `Bird` base class, a `FlyingBird` interface, and concrete classes such as `Sparrow` and `Penguin`.

## 2. Problem Statement

A general `Bird` class should not require every bird to implement flying behavior because some birds, such as penguins and ostriches, cannot fly.

The design must allow flying birds to fly without forcing non-flying birds to implement an unsupported method.

## 3. Theory

The **Liskov Substitution Principle (LSP)** is the third principle of SOLID.

It states that objects of a subtype should be usable wherever objects of the base type are expected without breaking program correctness.

In this practical, flying behavior is separated into the `FlyingBird` interface. Only birds capable of flying implement that interface.

## 4. Class Responsibilities

| Class / Interface | Responsibility |
|---|---|
| `Bird` | Defines general bird behavior through `eat()` |
| `FlyingBird` | Defines the `fly()` capability |
| `Sparrow` | Implements `Bird` and `FlyingBird` |
| `Penguin` | Extends `Bird` and provides eating and swimming behavior |
| `Main` | Demonstrates the behavior of both birds |

## 5. Project Structure

```text
01-lsp-birds/
├── README.md
└── src/
    └── com/
        └── harsh/
            └── sadp/
                └── birds/
                    ├── Bird.java
                    ├── FlyingBird.java
                    ├── Sparrow.java
                    ├── Penguin.java
                    └── Main.java
```

## 6. Technologies Used

- Java
- Object-Oriented Programming
- Inheritance and Interfaces
- SOLID Principles
- IntelliJ IDEA

## 7. How to Run

1. Open the project in IntelliJ IDEA or Eclipse.
2. Ensure all Java files use the package `com.harsh.sadp.birds`.
3. Open `Main.java`.
4. Run the `main()` method.
5. Verify the console output.

## 8. Expected Output

```text
Sparrow is eating.
Sparrow is flying.
Penguin is eating.
Penguin is swimming.
```

## 9. Advantages

- Prevents unsupported behavior from being imposed on subclasses.
- Separates flying capability from general bird behavior.
- Allows clients to depend on the `FlyingBird` interface when flying is required.
- Makes the design easier to extend with other flying and non-flying birds.

## 10. Viva Questions and Answers

**Q1. What is the Liskov Substitution Principle?**

LSP states that a subtype should be usable wherever its base type is expected without breaking program correctness.

**Q2. Why should `fly()` not be placed directly in the general `Bird` class?**

Because not all birds can fly. Placing `fly()` in the base class could force non-flying birds to provide unsupported behavior.

**Q3. Why is `FlyingBird` an interface?**

It represents the flying capability independently of the general bird type. Only birds capable of flying need to implement it.

**Q4. Can a `Penguin` be passed to a method that accepts `Bird`?**

Yes. `Penguin` extends `Bird`, so it can be used wherever a `Bird` is expected.

**Q5. Why does `makeFly()` accept `FlyingBird` rather than `Bird`?**

Because the method requires an object that supports `fly()`. The `FlyingBird` type guarantees that capability.

**Q6. How does this design demonstrate LSP?**

The design avoids promising that every `Bird` can fly. General bird behavior works through `Bird`, while flying operations require `FlyingBird`.

## 11. Conclusion

The Liskov Substitution Principle was demonstrated by separating general bird behavior from flying behavior. `Sparrow` implements both `Bird` and `FlyingBird`, while `Penguin` implements only the general bird behavior and its own swimming behavior.

This design prevents non-flying birds from being forced to implement unsupported operations and improves the flexibility of the application.