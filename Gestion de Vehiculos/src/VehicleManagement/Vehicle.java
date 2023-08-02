package VehicleManagement;

import java.time.LocalDate;

public abstract class Vehicle {
    private String brand;
    private String model;
    private String color;
    private int ageManufacture;
    private int passengerCapacity;

    public Vehicle(String brand, String model, String color, int ageManufacture, int passengerCapacity) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.ageManufacture = ageManufacture;
        this.passengerCapacity = passengerCapacity;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getAgeManufacture() {
        return ageManufacture;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public abstract float rentalCost(LocalDate rentalStartDate, LocalDate rentalEndDate);

    public abstract void vehicleInformation();

}
