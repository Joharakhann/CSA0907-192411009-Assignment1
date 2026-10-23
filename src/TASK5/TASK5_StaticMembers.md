# TASK 5 – Apply Static Members and the Object Life Cycle

---

## 1. Static Members & Global Counters

To maintain globally unique sequential IDs across all parking ticket instances regardless of facility, static members are used:

```java
public class ParkingTicket {
    private static int ticketCounter = 1000; // Shared across all instances
    private final String ticketId;

    public ParkingTicket(String regNo) {
        this.ticketId = "TICK-" + (++ticketCounter);
    }
}