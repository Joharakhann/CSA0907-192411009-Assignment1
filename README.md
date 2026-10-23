# Campus Smart-Parking System — Assignment 1

**Course:** CSA0907 - Object-Oriented Programming in Java  
**Student Name:** Fathi Muthu Johara M  
**Register Number:** 192411009  
**Java Version:** JDK 17 (JavaSE-17)  
**GitHub Repository:** [https://github.com/Joharakhann/CSA0907-192411009-Assignment1](https://github.com/Joharakhann/CSA0907-192411009-Assignment1)

---

## Complete Assignment Documentation (Tasks 1 to 12)

### TASK 1 – Understand the Problem and Identify the Objects
* **Inputs:** Registration Number, Vehicle Type (`TwoWheeler`, `Car`, `EV`), User Pass Status, Entry/Exit Timestamps, EV Charging consumption (kWh).
* **Outputs:** Slot Coordinates `{floor, slot}`, Ticket ID, Parking Fee receipt, Slot release confirmation.
* **Core Classes:** `Vehicle` (Abstract), `TwoWheeler`, `Car`, `ElectricCar`, `ParkingFacility`, `ParkingTicket`.
* **Business Rules:** Mutual exclusion per slot, unique sequential ticket IDs, billable hourly slabs, pass exemptions.
* **Design Rationale:** Encapsulation model guarantees data integrity over parallel arrays ($O(N)$ vs fragile synchronized tracking).

### TASK 2 – Choose the Data Representation
* **Data Types:** `floor`, `slot` (`int`), `regNo` (`String`), `entryTime` (`long`), `fee` (`double`).
* **Jagged Array Structure:** `String[][] slots` handles variable floor capacities without memory padding overhead.
* **Precision Risk:** Ceilings calculated via integer arithmetic `(minutes + 59) / 60` avoid truncation and floating-point errors.

### TASK 3 – Control Logic & Pseudocode
* **Pseudocode:** Nested linear scan `AllocateSlot(slots, vehicleNo)` iterates floor-by-floor returning `[f, s]` or `NULL`.
* **Implementation:** `ParkingFacility.java` implements slot allocation and release logic.
* **Complexity:** Linear scan $O(F \times S)$ time / $O(1)$ space; Stack/Queue approach gives $O(1)$ time with $O(F \times S)$ space.

### TASK 4 – Classes, Objects and Constructors
* **Encapsulation:** Private fields with parameterized constructors and `this(...)` constructor chaining prevent duplicate initialization.
* **Safety:** Constructor chaining and static factory methods guarantee state validation prior to instantiation.

### TASK 5 – Static Members and Life Cycle
* **Global Counters:** `private static int ticketCounter` ensures globally unique ticket IDs across all facilities.
* **Garbage Collection:** Removing vehicle references from `slots[][]` makes objects unreachable and eligible for JVM GC.

### TASK 6 – Inheritance Hierarchy
* **Structure:** `Vehicle` (Abstract) $\rightarrow$ `Car` $\rightarrow$ `ElectricCar`.
* **Constructor Tracing:** Calls parent constructors sequentially down through `Object()`, `Vehicle()`, `Car()`, and `ElectricCar()`.
* **Design Trade-off:** Inheritance cleanly specialization-models fixed physical behaviors.

### TASK 7 – Override and Specialise Behavior
* **Annotations:** `@Override` enforces compile-time signature checks.
* **Overrides:** Overridden `calculateFee()`, `equals()` (registration equality), and `hashCode()`.
* **OCP Compliance:** Avoids centralized `switch(type)` statements to prevent regression bugs.

### TASK 8 – Apply Polymorphism
* **Source Implementation:** `FeeDemo.java` with `Chargeable` interface for EV billing.
* **Execution Results:** `TwoWheeler` (Rs 30.0), `Car` (Rs 90.0), `ElectricCar` (Rs 210.0).

### TASK 9 – Abstraction
* **Abstract Class (`Vehicle`):** Defines core identity (`is-a`) and holds shared state (`regNo`).
* **Interface (`Chargeable`):** Defines capabilities (`can-do`) across unrelated class hierarchies.

### TASK 10 – Encapsulation & Packages
* **Packages:** `parking.model`, `parking.service`, `parking.app`.
* **Access Control:** Accessors and mutators enforce validation checks (e.g., throwing `IllegalArgumentException` on negative durations).

### TASK 11 – Testing & Data Structure Evaluation
* **Test Cases:** Validated normal allocation/release, full capacity behavior (`null`), boundary billing slabs, and duplicate entries.
* **Active Tickets Lookup:** `HashMap<String, ParkingTicket>` achieves $O(1)$ search and insertion vs $O(N)$ array scans.

### TASK 12 – Day-4 Design Challenge Adaptation
* **Extensions:** Added `EBike` (flat fee Rs 20.0), `DeliveryVan` (peak/off-peak billing), and `OneDayPass` (100% discount).
* **Open/Closed Principle:** Zero existing classes modified; extended through inheritance and interfaces.

---

## Instructions to Compile and Run

```bash
# --- Task 3: Parking Facility Slot Allocation ---
cd src/TASK03
javac ParkingFacility.java
java TASK03.ParkingFacility

# --- Task 8: Vehicle Hierarchy & Dynamic Polymorphism ---
cd ../TASK08
javac FeeDemo.java
java TASK08.FeeDemo

# --- Task 12: Day-4 Design Challenge ---
cd ../TASK12
javac Day4ChallengeDemo.java
java TASK12.Day4ChallengeDemo
