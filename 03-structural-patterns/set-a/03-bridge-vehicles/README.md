# Bridge Pattern — Vehicle Manufacturing

## Aim
To implement the Bridge Design Pattern to produce and assemble two different vehicles.

## Theory
The Bridge Pattern separates an abstraction from its implementation so that both can vary independently.

## Implementation
- `Vehicle` is the abstraction.
- `Car` and `Bike` are concrete vehicle types.
- `Workshop` defines the implementation interface.
- `Produce` and `Assemble` implement separate manufacturing operations.
- Each vehicle receives its manufacturing operations through composition.

## Conclusion
The Bridge Pattern was implemented successfully. Both Car and Bike use the same production and assembly abstractions without duplicating the workshop implementation classes.