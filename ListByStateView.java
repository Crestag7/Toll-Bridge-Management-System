// Author: Aadarsha Shrestha
// Description: Export all drivers from one state into a file.

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;

public class ListByStateView {

    public static void show(BinarySearchTree<Driver> tree) {
        Stage window = new Stage();

        // Input field for state code
        TextField stateField = new TextField();
        Button exportBtn = new Button("Export");

        VBox layout = new VBox(10, new Label("Enter State (like MI):"), stateField, exportBtn);
        layout.setStyle("-fx-padding: 20;");
        window.setScene(new Scene(layout, 300, 150));
        window.setTitle("Export By State");
        window.show();

        // Export button logic
        exportBtn.setOnAction(e -> {
            String stateCode = stateField.getText().trim().toUpperCase();

            try (FileWriter fw = new FileWriter("Drivers_" + stateCode + ".txt")) {
                // Traverse tree and write matching drivers
                tree.inorder(driver -> {
                    if (driver.getState().equalsIgnoreCase(stateCode)) {
                        try {
                            fw.write(driver.toString() + "\n");
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                showAlert("Exported to Drivers_" + stateCode + ".txt");
            } catch (IOException ex) {
                showAlert("Error: " + ex.getMessage());
            }
        });
    }

    // Alert message
    private static void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
        alert.showAndWait();
    }
}
