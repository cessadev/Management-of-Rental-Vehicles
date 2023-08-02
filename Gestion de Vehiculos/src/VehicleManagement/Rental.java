package VehicleManagement;

import java.time.LocalDate;

public class Rental {
    private Client client;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private Vehicle vehicle;

    public Rental(Client client, LocalDate rentalStartDate, LocalDate rentalEndDate, Vehicle vehicle) {
        this.client = client;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        this.vehicle = vehicle;
    }

    private float calculateTotalCost() {
        return vehicle.rentalCost(rentalStartDate, rentalEndDate);
    }

    public void clientInformation() {
        System.out.println("\n*** Client Information ***");
        System.out.println("Client Name: " + client.getClientName());
        System.out.println("Client Identification: " + client.getClientIdentification());
        System.out.println("Client Age: " + client.getClientAge());
        System.out.println("Client Phone Number: " + client.getClientPhoneNumber());
        System.out.println("Client Address: " + client.getClientAddress());
    }

    public void rentalsByClient() {
        System.out.println("\n*** Rentals by Client ***");
        for (Rental rental : client.getRentals()) {
            rental.rentalInformation();
        }
    }

    public void rentalInformation() {
        System.out.println("*******Rental Information*******");
        System.out.println("Client: " + client.getClientName());
        System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel());
        System.out.println("Start date: " + rentalStartDate);
        System.out.println("End date: " + rentalEndDate);
        System.out.println("Total cost: $" + calculateTotalCost());
    }
}
