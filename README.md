# DB test coding assignment

## Trading Signal Application

This project provides an application layer for a trading system that processes trading signals provided as simple integers.

### Overview

The core task was to create an application that can process various signals, with the expectation that a large number of new signals will be added regularly. The primary challenges were to ensure the system is:

- Easily maintainable and extensible
- Testable
- Understandable and debuggable for the development team

### Solutions Explored

- **Strategy Pattern**: This design would involve encapsulating each signal's behavior in a separate class implementing a common strategy interface. This approach provides high extensibility but can lead to class proliferation as the number of signals increases.
- **Map-based Approach (Chosen solution)**: This approach would store each signal as a key, with its corresponding actions as values, aiming to eliminate extensive switch or if-else structures. This approach would require a dynamic configuration thus creating an overhead during startup, especially with a significant number of signals, as well as the potential increased memory consumption.
- **Factory Design Pattern (Chosen Solution)**: This design involves using a factory to produce functional interfaces (SignalAction) based on the signal value. The chosen action is then executed. This approach offers a balance between extensibility, maintainability, and clarity.

### Testing

The test suite ensures the functionality of the new system matches the behavior of a legacy application for covered signals. Additionally, tests verify the correctness of individual signal behaviors and the factory logic. There are also parameterized tests implemented, that check the correctness of both implementations of action factories.

### Conclusion
In this task I scouted some approaches that I found the most fitting, but as there is no right solution to this problem, in the real-world scenario I would love to discuss different pros and cons with my teammates and see if they have any winning option in mind. 
However in this context, the **Map-based approach appears more suitable**. Given that the application will be initialized significantly fewer times than signal actions will be executed, the initial startup overhead becomes negligible
