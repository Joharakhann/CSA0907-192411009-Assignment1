# TASK 11 – Implement, Test and Defend the Design

---

## 1. Test Suite Scenarios

| Test ID | Scenario | Input | Expected Result |
| :--- | :--- | :--- | :--- |
| **TS-01** | Standard Allocation & Release | Slot allocation request | Coordinates returned; slot successfully released |
| **TS-02** | Full Capacity Allocation | Request on full facility array | Returns `null` without throwing exceptions |
| **TS-03** | Boundary Billing Slabs | 60 mins vs. 61 mins duration | Billed as 1 hr vs. 2 hrs respectively |
| **TS-04** | Duplicate Registration | Re-entry of active `regNo` | Entry request rejected |

---

## 2. Data Structure Comparison for Active Tickets

| Structure | Search Time | Insertion / Deletion | Memory Footprint |
| :--- | :--- | :--- | :--- |
| **Array** | $O(N)$ | $O(1)$ / $O(N)$ | Fixed upper limit |
| **ArrayList** | $O(N)$ | $O(1)$ amortized / $O(N)$ | Dynamic sizing |
| **`HashMap<String, ParkingTicket>`** | $O(1)$ | $O(1)$ | Hash entry overhead |