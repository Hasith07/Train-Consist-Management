import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String id;
    private int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() { return capacity; }
}

public class TrainPerformanceApp {

    public static void main(String[] args) {
        List<Bogie> consist = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            consist.add(new Bogie("B-" + i, (int) (Math.random() * 100)));
        }

        System.out.println("Benchmarking: Filtering " + consist.size() + " bogies (Capacity > 60)\n");

        // --- Approach 1: Traditional Loop ---
        long startTimeLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : consist) {
            if (b.getCapacity() > 60) {
                loopFiltered.add(b);
            }
        }
        long endTimeLoop = System.nanoTime();
        long durationLoop = endTimeLoop - startTimeLoop;

        // --- Approach 2: Java Stream ---
        long startTimeStream = System.nanoTime();
        List<Bogie> streamFiltered = consist.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long endTimeStream = System.nanoTime();
        long durationStream = endTimeStream - startTimeStream;

        // Display Results
        System.out.println("Result Check: Loop found " + loopFiltered.size() + ", Stream found " + streamFiltered.size());
        System.out.println("Loop Execution Time   : " + durationLoop + " ns");
        System.out.println("Stream Execution Time : " + durationStream + " ns");

        if (durationLoop < durationStream) {
            System.out.println("\nConclusion: Loop was " + (durationStream - durationLoop) + " ns faster.");
        } else {
            System.out.println("\nConclusion: Stream was " + (durationLoop - durationStream) + " ns faster.");
        }
    }
}