# Practical: Thread-Safe Singleton Design Pattern

## 1. Aim

To implement the Singleton Design Pattern in Java by creating a `DatabaseConnection` class that provides a single shared instance, even when accessed by multiple threads.

## 2. Problem Statement

An application may need a shared database connection manager that should have only one instance.

If multiple threads attempt to create instances simultaneously, the implementation must ensure that only one instance is created and shared among all callers.

The Singleton Design Pattern provides a controlled way to create and access a single instance of a class.

## 3. Theory

The **Singleton Design Pattern** is a creational design pattern that ensures a class has only one instance and provides a global access point to that instance.

In this practical:

- The constructor is declared `private`.
- The nested `Holder` class stores the single instance.
- The static `getConnection()` method provides access to the instance.
- Multiple threads call `getConnection()` and receive the same object.

### Initialization-on-demand holder idiom

This implementation uses a nested static holder class.

Java initializes the holder class when it is first actively used. Class initialization is thread-safe, so concurrent calls to `getConnection()` safely obtain the same instance without explicit synchronization on every call.

## 4. Class Responsibilities

| Component | Responsibility |
|---|---|
| `DatabaseConnection` | Controls instance creation and access |
| `Holder` | Stores the single `DatabaseConnection` instance |
| `getConnection()` | Returns the shared instance |
| `connect()` | Demonstrates using the shared instance |
| `Main` | Creates multiple threads and verifies shared access |

## 5. Project Structure

```text
02-singleton-database/
├── README.md
└── src/
    └── com/
        └── harsh/
            └── sadp/
                └── database/
                    ├── DatabaseConnection.java
                    └── Main.java
```

## 6. Technologies Used

- Java
- Object-Oriented Programming
- Static Nested Classes
- Multithreading
- Singleton Design Pattern
- IntelliJ IDEA

## 7. Implementation Approach

1. Declare the constructor of `DatabaseConnection` as private.
2. Create a static nested `Holder` class.
3. Initialize a single instance inside `Holder`.
4. Return the instance through `getConnection()`.
5. Create multiple threads in `Main`.
6. Let each thread call `getConnection()`.
7. Compare the identity hash codes to demonstrate shared instance access.

## 8. Expected Output

```text
DatabaseConnection instance created.
Thread-2 received instance: 833638717
Thread-3 received instance: 833638717
Thread-1 received instance: 833638717
```

The identity hash code shown above is an example. The actual value can differ between program executions, and the thread output order is not guaranteed.

The important observations are:

- The constructor message appears only once.
- All threads report the same identity hash code.
- The program terminates successfully.

## 9. Advantages

- Ensures a single instance within the class loader's scope.
- Provides a centralized access point.
- Supports thread-safe lazy initialization.
- Avoids explicit synchronization on every call to `getConnection()`.
- Demonstrates safe shared-object access across multiple threads.

## 10. Limitations

- A Singleton introduces globally shared state and can make unit testing more difficult.
- Its private constructor prevents ordinary external instantiation but does not prevent every possible mechanism from creating another instance.
- The example demonstrates a shared Java object, not an actual JDBC connection to a database server.
- A Singleton is not automatically a universal single instance across multiple JVMs or class loaders.

## 11. Viva Questions and Answers

**Q1. What is the Singleton Design Pattern?**

It is a creational design pattern that ensures a class has one instance and provides a global access point to it.

**Q2. Why is the constructor private?**

It prevents other classes from directly creating instances using the ordinary `new DatabaseConnection()` expression.

**Q3. Why is `getConnection()` static?**

It allows callers to access the instance without first creating a `DatabaseConnection` object.

**Q4. What is the purpose of the Holder class?**

It stores the Singleton instance and uses Java's class-initialization guarantees to initialize it safely when first accessed.

**Q5. Is the implementation thread-safe?**

Yes. The initialization-on-demand holder idiom relies on Java's thread-safe class initialization.

**Q6. What is lazy initialization?**

Lazy initialization means creating an object only when it is first needed, rather than when the application starts.

**Q7. Why do all threads receive the same object?**

Every thread calls `getConnection()`, which returns the same static instance stored in `Holder.INSTANCE`.

**Q8. What does `System.identityHashCode()` demonstrate?**

It provides an identity-based hash code for the object. Equal identity hash codes are useful for this demonstration, but they do not mathematically guarantee that two references point to the same object. Reference comparison with `==` is stronger.

**Q9. How can the same-instance property be verified directly?**

Store the returned references and compare them using `connection1 == connection2`.

**Q10. Does this program connect to a real database?**

No. It demonstrates the Singleton object-creation pattern. A real database connection would require JDBC configuration and an actual database.

## 12. Conclusion

The Singleton Design Pattern was implemented using the initialization-on-demand holder idiom. A private constructor restricts ordinary external instance creation, while the holder class safely initializes one shared instance.

The multithreaded test demonstrates that multiple threads can access the same instance concurrently.