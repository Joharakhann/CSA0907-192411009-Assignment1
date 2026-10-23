# TASK 2 – Choose the Data Representation

## 1. Primary Data Types Selection

* **`floor`, `slot`:** `int` — Represents zero-indexed integer coordinates within the facility matrix.
* **`regNo`:** `String` — Holds unique vehicle registration numbers (e.g., `"TN01AB1111"`).
* **`entryTime`:** `long` or `LocalDateTime` — Captures epoch timestamps or standard time objects for precise duration tracking.
* **`fee`:** `double` — Represents calculated financial values with decimal precision.

---

## 2. Jagged Array Matrix Structure

To represent multi-floor parking facilities with non-uniform capacities across floors (e.g., Floor 0: 20 slots, Floor 1: 50 slots):

```java
String[][] slots = new String[floors][];
slots[0] = new String[20]; // Floor 0 capacity
slots[1] = new String[50]; // Floor 1 capacity