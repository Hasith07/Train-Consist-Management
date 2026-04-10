import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

/**
 * UC11: Validate Train ID & Cargo Codes (Regex)
 * This program demonstrates format enforcement using the
 * Pattern and Matcher classes in Java.
 */

public class TrainConsistManagementUC11 {

    // Regex Constants
    // TRN- followed by exactly 4 digits
    private static final String TRAIN_ID_REGEX = "TRN-\\d{4}";

    // PET- followed by exactly 2 uppercase letters
    private static final String CARGO_CODE_REGEX = "PET-[A-Z]{2}";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   RAILWAY INPUT VALIDATION SYSTEM - UC11");
        System.out.println("==============================================");

        // 1. User enters Train ID
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainIdInput = scanner.nextLine();

        // 1. User enters Cargo Code
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCodeInput = scanner.nextLine();

        System.out.println("\n--- Validation Results ---");

        // 2, 3, & 4. Validate Train ID
        boolean isTrainIdValid = validateInput(trainIdInput, TRAIN_ID_REGEX);
        displayResult("Train ID", trainIdInput, isTrainIdValid, "TRN-xxxx (4 digits)");

        // 2, 3, & 4. Validate Cargo Code
        boolean isCargoCodeValid = validateInput(cargoCodeInput, CARGO_CODE_REGEX);
        displayResult("Cargo Code", cargoCodeInput, isCargoCodeValid, "PET-XX (2 uppercase letters)");

        System.out.println("==============================================");
        scanner.close();
    }

    /**
     * core Logic for Regex Validation
     * @param input The string to check
     * @param regex The pattern to follow
     * @return true if matches exactly
     */
    public static boolean validateInput(String input, String regex) {
        // Step 2: System compiles a regex pattern
        Pattern pattern = Pattern.compile(regex);

        // Step 3: Matcher checks input against the pattern
        Matcher matcher = pattern.matcher(input);

        // Step 4: Use matches() to check the entire string
        return matcher.matches();
    }

    private static void displayResult(String label, String value, boolean isValid, String expected) {
        if (isValid) {
            System.out.printf("✔ %s [%s]: VALID\n", label, value);
        } else {
            System.out.printf("❌ %s [%s]: INVALID (Expected %s)\n", label, value, expected);
        }
    }
}