# TASK 4 – Design Classes, Objects and Constructors


---

## 1. Class Member Design & Encapsulation

* **Instance Fields:** Core state variables like `regNo` and `entryTime` are declared as `private` or `protected` to enforce strict data encapsulation.
* **Access Control:** Public accessors (getters) expose read-only properties, preventing external code from mutating internal state unexpectedly.

---

## 2. Parameterized Constructors & Constructor Chaining

To prevent duplicate initialization logic across overloaded constructors, `this(...)` constructor chaining is used:

```java
public class ParkingTicket {
    private final String ticketId;
    private final String regNo;
    private final long entryTime;

    // Primary Constructor
    public ParkingTicket(String ticketId, String regNo, long entryTime) {
        this.ticketId = ticketId;
        this.regNo = regNo;
        this.entryTime = entryTime;
    }

    // Constructor Chaining (Defaults entryTime to current time)
    public ParkingTicket(String ticketId, String regNo) {
        this(ticketId, regNo, System.currentTimeMillis());
    }
}