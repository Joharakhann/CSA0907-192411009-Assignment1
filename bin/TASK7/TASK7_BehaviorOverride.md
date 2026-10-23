# TASK 7 – Override and Specialise Behavior

---

## 1. Method Overriding Rules

* **`@Override` Annotation:** Enforces strict compile-time signature verification against the superclass method.
* **Access Level Rule:** Overriding methods cannot reduce the visibility of the inherited superclass method (e.g., a `protected` superclass method cannot be overridden as `private`).

---

## 2. Core Method Overrides

1. **`calculateFee(int minutes)`:** Specialized implementation converting duration to billable hours and multiplying by vehicle-specific rates.
2. **`equals(Object o)`:** Overridden to evaluate equality strictly based on matching registration numbers (`regNo`).
3. **`hashCode()`:** Overridden to delegate directly to `regNo.hashCode()` ensuring consistency with `equals()`.

---

## 3. Switch Statement vs. Open/Closed Principle (OCP)

* **Switch Approach:** Placing a centralized `switch(type)` block inside a single `calculateFee()` method violates the **Open/Closed Principle (OCP)**. Adding new vehicle categories requires modifying core billing source code, increasing regression risk.
* **Polymorphic Overriding:** Encapsulates pricing rules inside each vehicle subclass, allowing new vehicle types to be added without altering existing code.