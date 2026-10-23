# TASK 1 – Understand the Problem and Identify the Objects

**Course:** CSA0907 - Object-Oriented Programming in Java  
**Student Name:** Fathi Muthu Johara M  
**Register Number:** 192411009  

---

## 1. System Inputs & Outputs

### Inputs
* **Vehicle Registration Number:** String (e.g., `"TN01AB1111"`)
* **Vehicle Type:** Enumerated / Categorical (`TwoWheeler`, `Car`, `EV`)
* **User Pass Status:** Categorical (`Student`, `Staff`, `Visitor`)
* **Entry and Exit Timestamps:** Date/Time representation
* **EV Charging Consumption:** double (kWh value)

### Outputs
* **Allocated Slot Coordinates:** Matrix position `{floor, slot}`
* **Parking Ticket:** Issued with sequential unique Ticket ID
* **Parking Fee Receipt:** Total calculated charge upon exit
* **Slot Release Confirmation:** Status message confirming slot availability

---

## 2. Candidate Classes & Responsibilities

| Class Name | Type | Core Responsibilities |
| :--- | :--- | :--- |
| `Vehicle` | Abstract Superclass | Encapsulates registration number; defines abstract `ratePerHour()`; implements `calculateFee(int minutes)`. |
| `TwoWheeler` | Concrete Subclass | Inherits `Vehicle`; defines flat hourly rate of **Rs 10**. |
| `Car` | Concrete Subclass | Inherits `Vehicle`; defines hourly rate of **Rs 30**. |
| `ElectricCar` | Concrete Subclass | Inherits `Car`; implements `Chargeable` interface (**Rs 12/kWh**). |
| `ParkingFacility` | Service Class | Manages multi-floor slot arrays, allocates first available free slot, releases slots. |
| `ParkingTicket` | Entity Class | Encapsulates transaction state (ticket ID, vehicle reference, timestamps, slot coordinates). |

---

## 3. Business Rules

1. **Mutual Exclusion:** A parking slot can hold at most one vehicle at any given instant.
2. **Ticket Uniqueness:** Ticket IDs are generated sequentially and are never reused.
3. **Billing Slabs:** Partial hours are rounded up; every starting hour is charged in full (e.g., 61 minutes = 2 billable hours).
4. **Pass Exemptions:** Valid monthly pass holders (`Staff`/`Student`) receive pass discounts or free parking.

---

## 4. Architectural Analysis: Parallel Arrays vs. Object Model

### Parallel Arrays Approach
* **Structure:** Using separate arrays such as `regNo[]`, `type[]`, and `entryTime[]`.
* **Drawbacks:** Requires manual index synchronization across multiple arrays. Adding attributes increases complexity exponentially and introduces a high risk of desynchronization bugs. Search efficiency is $O(N)$.

### OOP Encapsulation Model
* **Structure:** Groups all vehicle state inside dedicated object instances (`Vehicle`, `ParkingTicket`).
* **Advantages:** Guarantees data integrity through controlled accessors. Simplifies maintainability, scales easily, and reduces lookup time to $O(1)$ when backed by a map data structure.