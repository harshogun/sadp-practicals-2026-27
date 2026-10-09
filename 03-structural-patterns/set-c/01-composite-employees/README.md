# Composite Pattern — Employees and Managers

## Aim
To implement the Composite Design Pattern for representing individual employees and managers who supervise teams.

## Theory
The Composite Pattern organizes objects into tree structures and allows clients to treat individual objects and groups of objects uniformly.

## Implementation
- `Employee` defines the common component interface.
- `Developer` represents a leaf node, or individual employee.
- `Manager` represents a composite node containing a collection of employees or other managers.
- `Main` builds a reporting hierarchy and displays employee details recursively through the composite structure.

## Advantages
- Represents hierarchical structures naturally.
- Allows clients to treat individual employees and managers uniformly.
- Makes it easy to add or remove team members.

## Conclusion
The Composite Pattern was implemented successfully by creating a hierarchy of managers and developers using a shared `Employee` interface.