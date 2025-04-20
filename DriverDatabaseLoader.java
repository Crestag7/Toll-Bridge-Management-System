// Author: Aadarsha Shrestha
// Description: Loads driver data from a text file into a binary search tree.

import java.io.*;

public class DriverDatabaseLoader {
    public static BinarySearchTree<Driver> loadFromFile(String fileName) throws IOException {
        BinarySearchTree<Driver> tree = new BinarySearchTree<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        // Read each line of file
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                Driver d = new Driver(parts[0], parts[1], parts[2], parts[3],
                                      parts[4], parts[5], parts[6], parts[7]);
                tree.insert(d);
            }
        }

        reader.close();
        return tree;
    }
}
