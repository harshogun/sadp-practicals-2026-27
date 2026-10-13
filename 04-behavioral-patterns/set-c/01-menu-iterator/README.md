# Iterator Pattern — Breakfast, Lunch and Dinner Menus

## Aim
To implement the Iterator Design Pattern for traversing breakfast, lunch, and dinner menus.

## Theory
The Iterator Pattern provides a standard way to access elements of a collection sequentially without exposing the collection's internal representation.

## Implementation
- `MenuItem` represents an individual menu item.
- `MenuIterator` defines `hasNext()` and `next()`.
- `BreakfastMenu` stores items in an array.
- `LunchMenu` stores items in an `ArrayList`.
- `DinnerMenu` stores items in an array.
- `Main` traverses and displays all menus using the common iterator interface.

## Conclusion
The Iterator Pattern was implemented successfully. The same traversal logic works with different menu implementations and their underlying storage structures.