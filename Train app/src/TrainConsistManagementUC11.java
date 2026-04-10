import java.util.*;

/**
 * UC10: Count Total Seats in Train
 * This complete program demonstrates the Stream map-reduce pattern
 * to aggregate numerical data from a collection of bogie objects.
 */

// Model Class representing a single Bogie
class Bogie {
    private String id;
    private String bogieName;
    private int capacity;

    public Bogie(String id, String bogieName, int capacity) {
        this.id = id;
        this.bogieName = bogieName;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getBogieName() {
        return bogieName;
    }
    @Override
    public String toString() {
        return String.format("[%s | %s | Capacity: %d]", id, bogieName, capacity);
    }
}

// Main Application Class
public class TrainConsistManagementUC10{

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM - UC10");
        System.out.println("==============================================");

        // 1. Create the list of bogies (The Data Source)
        List<Bogie> consist = new ArrayList<>();
        consist.add(new Bogie("SL-01", "Sleeper", 72));
        consist.add(new Bogie("AC-01", "AC Chair", 50));
        consist.add(new Bogie("SL-02", "Sleeper", 72));
        consist.add(new Bogie("FC-01", "First Class", 24));
        consist.add(new Bogie("AC-02", "AC Chair", 50));

        System.out.println("\n[Action] Loading Train Consist Details...");
        consist.forEach(b -> System.out.println("Loaded: " + b));

        // 2, 3, & 4: The Stream Pipeline
        // Step 1: stream() - convert list to stream
        // Step 2: map() - transform Bogie object into its Integer capacity
        // Step 3: reduce() - aggregate all integers into a single sum
        int totalSeatingCapacity = consist.stream()
                .map(Bogie::getCapacity)        // Extract values
                .reduce(0, Integer::sum);       // Accumulate sum

        // 5. Display the aggregated results
        System.out.println("\n--- AGGREGATION SUMMARY ---");
        System.out.println("Total Passenger Bogies: " + consist.size());
        System.out.println("Total Seating Capacity: " + totalSeatingCapacity + " seats");

        // Logical Insight
        if (totalSeatingCapacity > 250) {
            System.out.println("Status: High-Capacity Train Configuration");
        } else {
            System.out.println("Status: Standard-Capacity Train Configuration");
        }

        // Integrity Check (Test Case Requirement)
        System.out.println("\n--- Integrity Verification ---");
        System.out.println("Is original list size unchanged? " + (consist.size() == 5));
        System.out.println("==============================================");
    }
}