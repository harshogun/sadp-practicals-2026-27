# Memento Pattern — Gumball Machine

## Aim
To implement the Memento Design Pattern to save and restore a gumball machine's internal state.

## Theory
The Memento Pattern captures an object's state so that it can be restored later without exposing its internal representation.

## Implementation
- `GumballMachine` is the originator. It manages the gumball count and quarter status.
- `MachineMemento` stores a snapshot of the machine's state.
- `saveState()` creates a snapshot.
- `restoreState()` restores the saved values.
- The machine supports inserting a quarter, removing a quarter, turning the crank, dispensing a gumball, and displaying its state.

## Conclusion
The Memento Pattern was implemented successfully. The machine's previous state can be restored after an operation without exposing its internal fields directly.