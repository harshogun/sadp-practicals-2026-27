# Command Pattern — Remote Control

## Aim
To implement the Command Design Pattern for operating a light through a remote control.

## Theory
The Command Pattern encapsulates a request as an object. It separates the object that invokes an operation from the object that performs it.

## Implementation
- `Command` defines the `execute()` operation.
- `Light` is the receiver that performs the actual operations.
- `LightOnCommand` and `LightOffCommand` encapsulate the respective requests.
- `RemoteControl` is the invoker that executes the assigned command.
- `Main` demonstrates switching the light on and off.

## Conclusion
The Command Pattern was implemented successfully. The remote control invokes light operations through command objects without directly depending on the receiver's implementation.