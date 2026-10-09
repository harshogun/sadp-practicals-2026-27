# Proxy Pattern — Image Loading

## Aim
To implement the Proxy Design Pattern to control access to an image object and avoid unnecessary loading.

## Theory
The Proxy Pattern provides a substitute object that controls access to a real object. A virtual proxy can delay creating the real object until it is required.

## Implementation
- `Image` defines the common interface.
- `RealImage` simulates loading and displaying an image.
- `ProxyImage` creates `RealImage` only when `display()` is first called.
- Subsequent calls reuse the existing object.

## Conclusion
The Proxy Pattern was implemented successfully. Lazy initialization ensures that the real image is loaded only when required and is reused for subsequent displays.