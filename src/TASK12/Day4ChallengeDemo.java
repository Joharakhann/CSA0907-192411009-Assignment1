package TASK12;

import java.time.LocalTime;
import java.util.Arrays;

// --- BASE FACILITY ---
class ParkingFacility {
    private final String[][] slots;

    public ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];
        for (int f = 0; f < slotsPerFloor.length; f++) {
            slots[f] = new String[slotsPerFloor[f]];
        }
    }

    public int[] allocate(String vehicleNo) {
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = vehicleNo;
                    return new int[]{f, s};
                }
            }
        }
        return null;
    }

    public boolean release(int floor, int slot) {
        if (floor < 0 || floor >= slots.length) return false;
        if (slot < 0 || slot >= slots[floor].length) return false;
        if (slots[floor][slot] == null) return false;
        slots[floor][slot] = null;
        return true;
    }
}

// --- BASE VEHICLE HIERARCHY ---
abstract class Vehicle {
    private final String regNo;

    protected Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    protected abstract double ratePerHour();

    public double calculateFee(int minutes) {
        int hours = (minutes + 59) / 60;
        return hours * ratePerHour();
    }
}

class Car extends Vehicle {
    public Car(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 30.0;
    }
}

// --- TASK 12 EXTENSIONS ---
interface Pass {
    double applyDiscount(double fee);
}

class OneDayPass implements Pass {
    @Override
    public double applyDiscount(double fee) {
        return 0.0; // 100% discount
    }
}

class EBike extends Vehicle {
    public EBike(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 0.0;
    }

    @Override
    public double calculateFee(int minutes) {
        return 20.0; // Flat fee
    }
}

class DeliveryVan extends Vehicle {
    public DeliveryVan(String regNo) {
        super(regNo);
    }

    @Override
    protected double ratePerHour() {
        return 30.0;
    }

    public double calculateFee(int minutes, LocalTime entryTime) {
        int hours = (minutes + 59) / 60;
        boolean isPeak = entryTime.getHour() >= 9 && entryTime.getHour() < 17;
        return hours * (isPeak ? 60.0 : 30.0);
    }
}

// --- MAIN DEMO CLASS ---
public class Day4ChallengeDemo {
    public static void main(String[] args) {
        // 5-floor facility with dynamic slot capacity per floor
        ParkingFacility facility5Floors = new ParkingFacility(new int[]{20, 30, 50, 50, 100});

        System.out.println("--- Day-4 Design Challenge Tests ---");

        // 1. EBike Flat Fee Test
        EBike ebike = new EBike("TN05EB001");
        System.out.println("EBike Fee (300 mins): Rs " + ebike.calculateFee(300));

        // 2. Delivery Van Peak vs Off-Peak Test
        DeliveryVan van = new DeliveryVan("TN09DV999");
        System.out.println("Van Fee (120 mins @ 10 AM Peak): Rs " + van.calculateFee(120, LocalTime.of(10, 0)));
        System.out.println("Van Fee (120 mins @ 7 PM Off-Peak): Rs " + van.calculateFee(120, LocalTime.of(19, 0)));

        // 3. One-Day Pass Test
        Car visitorCar = new Car("TN02CB123");
        Pass pass = new OneDayPass();
        double standardFee = visitorCar.calculateFee(180);
        double finalFee = pass.applyDiscount(standardFee);
        System.out.println("Visitor Car with One-Day Pass Fee: Rs " + finalFee);

        // 4. Slot Allocation Test on 5-Floor Facility
        int[] slot = facility5Floors.allocate("TN05EB001");
        System.out.println("Allocated Slot on 5-Floor Facility: " + Arrays.toString(slot));
    }
}