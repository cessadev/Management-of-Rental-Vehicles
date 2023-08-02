package VehicleManagement;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String clientName;
    private int clientIdentification;
    private int clientAge;
    private int clientPhoneNumber;
    private String clientAddress;
    private List<Rental> rentals;

    public Client (String clientName, int clientIdentification, int clientAge, int clientPhoneNumber, String clientAddress) {
        this.clientName = clientName;
        this.clientIdentification = clientIdentification;
        this.clientAge = clientAge;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientAddress = clientAddress;
        this.rentals = new ArrayList<>();
    }

    public String getClientName() {
        return clientName;
    }

    public int getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public int getClientAge() {
        return clientAge;
    }

    public int getClientIdentification() {
        return clientIdentification;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public List<Rental> getRentals() {
        return rentals;
    }

}
