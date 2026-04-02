import java.util.ArrayList;

public class TrainConsistManagement {

    public static void main(String[] args) {


        ArrayList<String> passengerBogies = new ArrayList<>();


        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");


        System.out.println("Passenger Bogies after addition:");
        System.out.println(passengerBogies);


        passengerBogies.remove("AC Chair");


        System.out.println("\nPassenger Bogies after removal of AC Chair:");
        System.out.println(passengerBogies);


        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie exists in the train.");
        } else {
            System.out.println("\nSleeper bogie does not exist in the train.");
        }


        System.out.println("\nFinal Passenger Bogies List:");
        System.out.println(passengerBogies);
    }
}