import java.util.*;
import java.util.stream.Collectors;



class Bogie {
    private String id;
    private String bogieName;
    private int capacity;

    public Bogie(String id, String bogieName, int capacity) {
        this.id = id;
        this.bogieName = bogieName;
        this.capacity = capacity;
    }

    public String getBogieName() {
        return bogieName;
    }

    @Override
    public String toString() {
        return String.format("[%s | %s | Capacity: %d]", id, bogieName, capacity);
    }
}


public class TrainConsistManagementUC9 {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("   TRAIN CONSIST MANAGEMENT SYSTEM - UC9");
        System.out.println("==============================================");

        // 1. Create the flat list of bogies
        List<Bogie> consist = new ArrayList<>();
        consist.add(new Bogie("SL-101", "Sleeper", 72));
        consist.add(new Bogie("AC-201", "AC Chair", 50));
        consist.add(new Bogie("SL-102", "Sleeper", 72));
        consist.add(new Bogie("FC-301", "First Class", 24));
        consist.add(new Bogie("AC-202", "AC Chair", 50));
        consist.add(new Bogie("GD-401", "Rectangular Goods", 100));

        System.out.println("\n[System] Successfully loaded " + consist.size() + " bogies into the stream.");


        Map<String, List<Bogie>> groupedReport = consist.stream()
                .collect(Collectors.groupingBy(Bogie::getBogieName));

        System.out.println("\n--- GENERATING GROUPED REPORT ---");

        if (groupedReport.isEmpty()) {
            System.out.println("No data available to group.");
        } else {
            groupedReport.forEach((type, list) -> {
                System.out.println("\nBOGIE TYPE: " + type.toUpperCase());
                System.out.println("Count in Consist: " + list.size());
                System.out.println("----------------------------------------------");
                list.forEach(b -> System.out.println("  > " + b));
            });
        }

        System.out.println("\n==============================================");
        System.out.println("Final Check:");
        System.out.println("Original List Intact: " + (consist.size() == 6));
        System.out.println("Total Distinct Groups: " + groupedReport.size());
        System.out.println("==============================================");
    }
}