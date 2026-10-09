# Weather Station — Observer Pattern

## Aim
To implement a weather station using Java's built-in `java.util.Observable` and `java.util.Observer` support.

## Theory
The Observer Pattern defines a one-to-many relationship between objects. When the subject changes its state, its registered observers are notified automatically.

## Implementation
- `WeatherData` extends `Observable` and stores temperature, humidity, and pressure.
- `setMeasurement()` updates the measurements and invokes `measurementsChanged()`.
- `measurementsChanged()` marks the subject as changed and notifies registered observers.
- `CurrentConditionsDisplay` implements `Observer` and displays the updated weather information.
- `Main` registers the observer and demonstrates three measurement updates.

## Conclusion
The Observer Pattern was demonstrated successfully. The weather station notifies its registered display whenever new measurements are available.