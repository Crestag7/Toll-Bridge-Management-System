// Author: Aadarsha Shrestha
// Description: This class stores one driver and all their information.


public class Driver implements Comparable<Driver> {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
// ... (code under development)
    // Compare by license plate (used in BST)
    public int compareTo(Driver other) {
        return this.licensePlate.compareTo(other.licensePlate);
    }
}
