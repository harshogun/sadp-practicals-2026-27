# Prototype Pattern — Shapes

## Aim
To implement the Prototype Design Pattern using a `Shape` interface and concrete `Circle` and `Rectangle` classes.

## Theory
The Prototype Pattern creates new objects by cloning existing objects instead of constructing them from scratch.

## Implementation
- `Shape` defines the `clone()` and `display()` methods.
- `Circle` clones its radius into a new object.
- `Rectangle` clones its length and width into a new object.
- `Main` creates original shapes, clones them, and verifies that the clones are distinct objects with matching values.

## Conclusion
The Prototype Pattern was implemented successfully. Both shapes were cloned, preserving their property values while creating separate object instances.