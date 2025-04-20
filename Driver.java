// Author: Aadarsha Shrestha
// Description: This class stores one driver and all their information.


public class Driver implements Comparable<Driver> {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String licensePlate;

    // Constructor
    public Driver(String firstName, String lastName, String address, String city,
                  String state, String zip, String phone, String licensePlate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.licensePlate = licensePlate;
    }

    // Get license plate
    public String getLicensePlate() {
        return licensePlate;
    }

    // Get state
    public String getState() {
        return state;
    }

    // Convert driver to CSV-style string
    public String toString() {
        return firstName + "," + lastName + "," + address + "," + city + "," +
               state + "," + zip + "," + phone + "," + licensePlate;
    }

    // Compare by license plate (used in BST)
    public int compareTo(Driver other) {
        return this.licensePlate.compareTo(other.licensePlate);
    }
}
