// Author: Aadarsha Shrestha
// Description: Processes a queue of license plates crossing the bridge and counts Michigan residents and unknowns.


import java.io.*;
import java.util.*;

public class BridgeQueueProcessor {

    public static void processQueue(String fileName, BinarySearchTree<Driver> tree) throws IOException {
        Queue<String> plates = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;

        // Add license plates to queue
        while ((line = reader.readLine()) != null) {
            plates.add(line.trim());
        }

        reader.close();

        int michiganCount = 0;
        int notFound = 0;

        // Process each plate in queue
        while (!plates.isEmpty()) {
            String plate = plates.poll();

            Driver dummy = new Driver("", "", "", "", "", "", "", plate);
            Driver found = tree.search(dummy);

            if (found != null && found.getState().equals("MI")) {
                michiganCount++;
            } else if (found == null) {
                notFound++;
            }
        }

        // Print results
        System.out.println("Michigan residents: " + michiganCount);
        System.out.println("Not found in database: " + notFound);
    }
}
