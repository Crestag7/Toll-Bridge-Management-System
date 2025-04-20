// Author: Aadarsha Shrestha
// Description: Admin screen to choose Edit, Process, List, or Quit.


import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class AdminDashboard {
    static BinarySearchTree<Driver> driverTree;

    public static void show(Stage stage) {
        // Buttons for actions
        Button editBtn = new Button("Edit Drivers");
        Button processBtn = new Button("Process Travelers");
        Button listBtn = new Button("List Drivers by State");
        Button quitBtn = new Button("Quit");

        // Actions
        editBtn.setOnAction(e -> EditDriverView.show(stage, driverTree));
        processBtn.setOnAction(e -> TravelerProcessorView.show(driverTree));
        listBtn.setOnAction(e -> ListByStateView.show(driverTree));
        quitBtn.setOnAction(e -> {
            try {
                driverTree.saveToFile("DriverDatabaseBackup.txt");
            } catch (IOException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error saving file: " + ex.getMessage());
                alert.showAndWait();
            }
            stage.close();
        });

        VBox layout = new VBox(10, editBtn, processBtn, listBtn, quitBtn);
        layout.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(layout, 300, 200));
        stage.setTitle("Admin Panel");
    }
}
