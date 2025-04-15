// Author: Aadarsha Shrestha
// Description: Loads driver data from a text file into a binary search tree.

import java.io.*;

public class DriverDatabaseLoader {
    public static BinarySearchTree<Driver> loadFromFile(String fileName) throws IOException {
        BinarySearchTree<Driver> tree = new BinarySearchTree<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
// ... (code under development)

        reader.close();
        return tree;
    }
}
