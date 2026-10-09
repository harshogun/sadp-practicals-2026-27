# Adapter Pattern — Heart Model to Beat Model

## Aim
To implement the Adapter Design Pattern to make a Heart Model compatible with the Beat Model interface.

## Theory
The Adapter Pattern converts an existing interface into another interface expected by the client, allowing incompatible interfaces to work together.

## Implementation
- `HeartModel` represents the existing heart-rate model.
- `BeatModel` defines the interface expected by the client.
- `HeartModelAdapter` implements `BeatModel` and delegates BPM retrieval to `HeartModel`.
- `Main` demonstrates accessing the heart rate through the adapter.

## Conclusion
The Adapter Pattern was implemented successfully. The client accesses the Heart Model through the Beat Model interface without changing the existing model class.