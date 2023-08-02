package VehicleManagement;

import java.util.ArrayList;
import java.util.List;

public class VehicleInventory {
    private List<Vehicle> cars = new ArrayList<>();
    private List<Vehicle> motorcycles = new ArrayList<>();
    private List<Vehicle> bikes = new ArrayList<>();

    public void initializeVehicleLists() {
        Car[] carArray = {
                new Car("BMW", "S110", "Red", 2020, 4),
                new Car("Toyota", "Camry", "Blue", 2019, 5),
                new Car("Ford", "Mustang", "Black", 2022, 2),
                new Car("Honda", "Civic", "Silver", 2021, 4),
                new Car("Chevrolet", "Equinox", "White", 2023, 5)
        };

        for (Car car : carArray) {
            cars.add(car);
        }

        Motorcycle[] motorcycleArray = {
                new Motorcycle("Honda", "X500S", "Blue", 2022, 2),
                new Motorcycle("Honda", "X500S", "Blue", 2022, 2),
                new Motorcycle("Yamaha", "YZF-R6", "Black", 2023, 1),
                new Motorcycle("Kawasaki", "Ninja 300", "Green", 2021, 2),
                new Motorcycle("Suzuki", "GSX-S750", "Gray", 2020, 2)
        };

        for (Motorcycle motorcycle : motorcycleArray) {
            motorcycles.add(motorcycle);
        }

        Bike[] bikeArray = {
                new Bike("Xtrem", "X500S", "Gray", 2023, 1),
                new Bike("MountainRider", "M320", "Black", 2022, 2),
                new Bike("UrbanCruiser", "UC200", "White", 2021, 1),
                new Bike("CityGlide", "CG125", "Red", 2020, 1)
        };

        for (Bike bike : bikeArray) {
            bikes.add(bike);
        }
    }

    public List<Vehicle> getCars() {
        return cars;
    }

    public List<Vehicle> getMotorcycles() {
        return motorcycles;
    }

    public List<Vehicle> getBikes() {
        return bikes;
    }
}
