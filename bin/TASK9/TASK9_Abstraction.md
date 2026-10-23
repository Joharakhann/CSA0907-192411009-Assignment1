# TASK 9 – Introduce Abstraction

---

## Abstract Class vs. Interface Comparison

| Criterion | Abstract Class (`Vehicle`) | Interface (`Chargeable`) |
| :--- | :--- | :--- |
| **State** | Holds shared instance state (`regNo`). | Cannot hold instance state (only constants). |
| **Hierarchy** | Defers `ratePerHour()` implementation to concrete subtypes. | Defines capability contracts across unrelated class branches. |
| **Inheritance** | Enforces single class inheritance model. | Permits multiple interface implementations. |
| **Design Intent** | Models core identity (**is-a** relationship). | Models dynamic functionality/capability (**can-do** relationship). |