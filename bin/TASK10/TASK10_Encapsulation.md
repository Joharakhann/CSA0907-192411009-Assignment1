# TASK 10 – Enforce Encapsulation through Packages and Access Modifiers

---

## 1. Package Layout & Architecture

The system is organized into modular packages to separate domain entities, business logic, and application entry points:

* **`parking.model`:** Domain entities (`Vehicle`, `ParkingTicket`)[cite: 5]
* **`parking.service`:** Business logic (`AllocationService`, `BillingService`)[cite: 5]
* **`parking.app`:** Entry point and UI/CLI integration (`Main`)[cite: 5]

---

## 2. Access Control & Defensive Validation

* **Field Protection:** All instance fields are declared `private` to prevent unauthorized external access[cite: 5].
* **Controlled Accessors:** Public getters expose read-only attributes without exposing internal implementation details[cite: 5].
* **Input Validation:** Mutators and methods enforce parameter checks, raising runtime exceptions (e.g., `IllegalArgumentException`) when receiving invalid inputs such as negative durations[cite: 5].