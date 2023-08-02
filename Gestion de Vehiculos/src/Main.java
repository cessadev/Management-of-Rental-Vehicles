import VehicleManagement.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VehicleRentalManagement rentalManagement = new VehicleRentalManagement();

        Scanner scanner = new Scanner(System.in);

        boolean responseIsValid = false;
        while (!responseIsValid) {
            // Ask the client if he wants to rent a vehicle
            System.out.println("Do you want to rent a vehicle? (yes/no): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("yes")) {
                // Ask the client what type of vehicle he wants to rent
                String vehicleType;
                do {
                    // Ask the client what type of vehicle he wants to rent
                    System.out.println("What type of vehicle do you want to rent? (Car/Motorcycle/Bike): ");
                    vehicleType = scanner.nextLine().toLowerCase();

                    if (!vehicleType.equals("car") && !vehicleType.equals("motorcycle") && !vehicleType.equals("bike")) {
                        System.out.println("Invalid option. Please enter one of the three allowed options (Car/Motorcycle/Bike).");
                    }
                } while (!vehicleType.equals("car") && !vehicleType.equals("motorcycle") && !vehicleType.equals("bike"));

                rentalManagement.showVehicleInventory(vehicleType);

                // Validates that the ID is an integer
                int vehicleIndex = rentalManagement.inputId(scanner);

                // Validate the ID selected by the client
                rentalManagement.validateIdAndRegister(vehicleIndex, scanner);

                rentalManagement.inputDateTime(scanner);
                rentalManagement.createRental();

                responseIsValid = true;
            } else if (response.equalsIgnoreCase("no")) {
                System.out.println("Thanks for using our services, Bye!");
                responseIsValid = true;
            } else {
                System.out.println("Invalid answer, please respond 'yes' or 'no'");
            }
        }
        scanner.close();
    }
}