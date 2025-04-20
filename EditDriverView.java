// Author: Aadarsha Shrestha
// Description: JavaFX screen to edit driver data using license plate.

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class EditDriverView {

    public static void show(Stage stage, BinarySearchTree<Driver> tree) {
        // Input fields
        TextField plateField = new TextField();
        TextField first = new TextField();
        TextField last = new TextField();
        TextField address = new TextField();
        TextField city = new TextField();
        ComboBox<String> state = new ComboBox<>();
        state.getItems().addAll("MI", "VA", "NC", "TN", "RI", "NV", "CA", "NY", "TX", "FL", "OH");
        TextField zip = new TextField();
        TextField phone = new TextField();

        // Buttons
        Button search = new Button("Search");
        Button update = new Button("Update");
        Button delete = new Button("Delete");
        Button add = new Button("Add New");
        Button back = new Button("Back");

        // Layout for form
        GridPane grid = new GridPane();
        grid.setHgap(10); grid.setVgap(10);
        grid.addRow(0, new Label("License Plate:"), plateField, search);
        grid.addRow(1, new Label("First Name:"), first);
        grid.addRow(2, new Label("Last Name:"), last);
        grid.addRow(3, new Label("Address:"), address);
        grid.addRow(4, new Label("City:"), city);
        grid.addRow(5, new Label("State:"), state);
        grid.addRow(6, new Label("ZIP:"), zip);
        grid.addRow(7, new Label("Phone:"), phone);

        VBox layout = new VBox(10, grid, new HBox(10, update, delete, add, back));
        layout.setStyle("-fx-padding: 20;");
        stage.setScene(new Scene(layout, 500, 400));
        stage.setTitle("Edit Drivers");

        // Search button logic
        search.setOnAction(e -> {
            Driver dummy = new Driver("", "", "", "", "", "", "", plateField.getText());
            Driver found = tree.search(dummy);
            if (found != null) {
                // Populate fields with data
                first.setText(found.firstName);
                last.setText(found.lastName);
                address.setText(found.address);
                city.setText(found.city);
                state.setValue(found.state);
                zip.setText(found.zip);
                phone.setText(found.phone);
            } else {
                show("Driver not found");
            }
        });

        // Update driver info
        update.setOnAction(e -> {
            Driver old = new Driver("", "", "", "", "", "", "", plateField.getText());
            Driver updated = new Driver(first.getText(), last.getText(), address.getText(), city.getText(),
                                        state.getValue(), zip.getText(), phone.getText(), plateField.getText());
            tree.update(old, updated);
            show("Driver updated");
        });

        // Delete driver from tree
        delete.setOnAction(e -> {
            Driver del = new Driver("", "", "", "", "", "", "", plateField.getText());
            tree.delete(del);
            show("Driver deleted");
        });

        // Add a new driver to the tree
        add.setOnAction(e -> {
            Driver newDriver = new Driver(first.getText(), last.getText(), address.getText(), city.getText(),
                                          state.getValue(), zip.getText(), phone.getText(), plateField.getText());
            tree.insert(newDriver);
            show("Driver added");
        });

        // Return to admin dashboard
        back.setOnAction(e -> AdminDashboard.show(stage));
    }

    // Show alert message
    private static void show(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg);
        alert.showAndWait();
    }
}
