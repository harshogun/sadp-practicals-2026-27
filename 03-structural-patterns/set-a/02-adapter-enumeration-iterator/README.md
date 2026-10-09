# Adapter Pattern — Enumeration to Iterator

## Aim
To implement the Adapter Design Pattern that allows an `Enumeration` to be used through the `Iterator` interface.

## Theory
The Adapter Pattern converts one interface into another interface expected by the client.

## Implementation
- `EnumerationIterator` implements the `Iterator` interface.
- It wraps an existing `Enumeration` object.
- `hasNext()` delegates to `hasMoreElements()`.
- `next()` delegates to `nextElement()`.
- `remove()` is unsupported because `Enumeration` does not provide a corresponding removal operation.

## Conclusion
The Adapter Pattern was implemented successfully, allowing elements of a `Vector` to be traversed using the `Iterator` interface through an `Enumeration` adapter.