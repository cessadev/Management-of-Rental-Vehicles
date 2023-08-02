package VehicleManagement;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Bike extends Vehicle {
    public Bike(String brand, String model, String color, int ageManufacture, int passengerCapacity) {
        super(brand, model, color, ageManufacture, passengerCapacity);
    }

    public float rentalCost(LocalDate rentalStartDate, LocalDate rentalEndDate) {
        if (rentalEndDate.isBefore(rentalStartDate)) {
            throw new IllegalArgumentException("The rental end date must be later than the start date.");
        }
        float bikeCost = 10.0f;
        float totalCost = bikeCost * ChronoUnit.DAYS.between(rentalStartDate, rentalEndDate);
        return totalCost;
    }

    public void vehicleInformation() {
        System.out.println("*Bike Information*");
        System.out.println("Brand: " + getBrand());
        System.out.println("Model: " + getModel());
        System.out.println("Color: " + getColor());
        System.out.println("Age of manufacture: " + getAgeManufacture());
        System.out.println("Passenger capacity: " + getPassengerCapacity());
    }
}
