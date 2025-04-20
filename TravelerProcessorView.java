
// Author: Aadarsha Shrestha
// Description: Reads license plates from file, shows Michigan and unknown plate counts.


import javafx.scene.control.Alert;
import java.io.*;
import java.util.*;

public class TravelerProcessorView {

    public static void show(BinarySearchTree<Driver> tree) {
        File file = new File("passageQueue.txt");  // File with license plates

        if (!file.exists()) {
            showAlert("File passageQueue.txt not found.");
            return;
        }

        try {
            Queue<String> queue = new LinkedList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                queue.add(line.trim()); // Add license plate to queue
            }

            reader.close();

            int michigan = 0;
            int notFound = 0;

            // Go through the plates
            while (!queue.isEmpty()) {
                String plate = queue.poll();
                Driver dummy = new Driver("", "", "", "", "", "", "", plate);
                Driver found = tree.search(dummy);

                if (found != null && found.getState().equalsIgnoreCase("MI")) {
                    michigan++;
                } else if (found == null) {
                    notFound++;
                }
            }

            // Show result
            showAlert("Michigan plates: " + michigan + "\nNot found: " + notFound);
        } catch (IOException e) {
            showAlert("Error reading file: " + e.getMessage());
        }
    }

    private static void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
        alert.showAndWait();
    }
}
