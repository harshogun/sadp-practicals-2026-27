# Command Pattern — Ceiling Fan

## Aim
To implement the Command Design Pattern for controlling a ceiling fan and supporting undo operations.

## Theory
The Command Pattern encapsulates a request as an object, allowing commands to be executed and undone independently of the receiver.

## Implementation
- `CeilingFan` is the receiver that performs fan operations.
- `Command` defines `execute()` and `undo()`.
- `FanOnCommand`, `FanOffCommand`, and `FanSpeedCommand` encapsulate fan operations.
- Each reversible command stores the previous state needed for undo.
- `Main` demonstrates speed changes, switching off, and undo operations.

## Conclusion
The Command Pattern was implemented successfully, allowing fan commands to be executed and their previous speed restored through undo operations.