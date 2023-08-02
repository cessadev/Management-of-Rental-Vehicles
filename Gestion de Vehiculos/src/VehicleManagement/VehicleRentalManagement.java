package VehicleManagement;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class VehicleRentalManagement {
    private List<Vehicle> vehicleInventory;
    private Client client;
    private Vehicle selectedVehicle;
    private LocalDate rentalStartDate, rentalEndDate;

    public List<Vehicle> showVehicleInventory(String vehicleType) {
        VehicleInventory listVehicles = new VehicleInventory();
        listVehicles.initializeVehicleLists();

        switch (vehicleType.toLowerCase()) {
            case "car":
                vehicleInventory = listVehicles.getCars();
                break;
            case "motorcycle":
                vehicleInventory = listVehicles.getMotorcycles();
                break;
            case "bike":
                vehicleInventory = listVehicles.getBikes();
                break;
            default:
                System.out.println("Type of vehicle invalid.");
                throw new IllegalArgumentException("Type of vehicle invalid.");
        }
        searchVehicleInventory(vehicleInventory);
        return vehicleInventory;
    }

    public Client validateIdAndRegister(int vehicleIndex, Scanner scanner) {
        if (vehicleInventory != null && vehicleIndex >= 0 && vehicleIndex < vehicleInventory.size()) {
            selectedVehicle = vehicleInventory.get(vehicleIndex);

            System.out.println("Enter client name: Ex: Joy Dalton");
            String clientName = scanner.nextLine();

            int clientIdentification = 0;
            boolean isValidIdentification = false;
            while (!isValidIdentification) {
                System.out.println("Enter client identification: ");
                try {
                    clientIdentification = Integer.parseInt(scanner.nextLine());
                    isValidIdentification = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric value for identification. Ex: 0344886");
                }
            }

            int clientAge = 0;
            boolean isValidAge = false;
            while (!isValidAge) {
                System.out.println("Enter client age: ");
                try {
                    clientAge = Integer.parseInt(scanner.nextLine());
                    isValidAge = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric value for age. Ex: 18");
                }
            }

            int clientPhoneNumber = 0;
            boolean isValidPhoneNumber = false;
            while (!isValidPhoneNumber) {
                System.out.println("Enter client phone number: ");
                try {
                    clientPhoneNumber = Integer.parseInt(scanner.nextLine());
                    isValidPhoneNumber = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid numeric value for phone number. Ex: 3220669966");
                }
            }

            System.out.println("Enter client address. Ex: Cl 25 #24-05 San Luis, California");
            String clientAddress = scanner.nextLine();

            client = new Client(clientName, clientIdentification, clientAge, clientPhoneNumber, clientAddress);
        }
        if (client == null) {
            throw new IllegalArgumentException("Client is not registered.");
        }
        return client;
    }

    public void inputDateTime(Scanner scanner) {
        rentalStartDate = readLocalDateFromUser(scanner, "Enter the rental start date (yyyy-MM-dd): ");
        rentalEndDate = readLocalDateFromUser(scanner, "Enter the rental end date (yyyy-MM-dd): ");
    }

    public void createRental() {
        Rental newRental = new Rental(client, rentalStartDate, rentalEndDate, selectedVehicle);
        client.addRental(newRental);
        newRental.clientInformation();
        newRental.rentalsByClient();
    }

    public int inputId(Scanner scanner) {
        System.out.println("Enter the ID of the vehicle you want to rent: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer value for the vehicle ID.");
            scanner.nextLine();
        }
        int vehicleIndex = scanner.nextInt();
        scanner.nextLine();
        return vehicleIndex;
    }

    private static void searchVehicleInventory(List<Vehicle> vehicles) {
        System.out.println("Vehicles inventory:");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("ID: " + i);
            vehicles.get(i).vehicleInformation();
            System.out.println();
        }
    }

    private static LocalDate readLocalDateFromUser(Scanner scanner, String prompt) {
        LocalDate date = null;
        boolean isValidDate = false;

        while (!isValidDate) {
            try {
                System.out.println(prompt);
                String dateString = scanner.nextLine();
                date = LocalDate.parse(dateString);
                isValidDate = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }

        return date;
    }
}
