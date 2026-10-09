# I/O Decorator — Lowercase Reader

## Aim
To implement the Decorator Design Pattern using Java I/O classes to convert uppercase letters to lowercase.

## Theory
The Decorator Pattern dynamically adds behavior to an object by wrapping it with another object. Java's `FilterReader` allows a reader to be wrapped with additional reading behavior.

## Implementation
- `LowerCaseReader` extends `FilterReader`.
- It wraps an existing `Reader`.
- Both single-character and character-buffer reads convert characters to lowercase.
- `Main` demonstrates the decorator using a `StringReader`.

## Conclusion
The I/O Decorator was implemented successfully, converting uppercase input to lowercase while preserving the original reader's interface.