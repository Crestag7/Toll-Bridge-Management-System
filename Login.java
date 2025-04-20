// Author: Aadarsha Shrestha
// Description: JavaFX Login screen. Only admin/admin can log in.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Labels and text fields for username and password
        Label userLabel = new Label("Username:");
        TextField userField = new TextField();

        Label passLabel = new Label("Password:");
        PasswordField passField = new PasswordField();

        // Login button
        Button loginButton = new Button("Login");

        // Layout setup
        VBox layout = new VBox(10, userLabel, userField, passLabel, passField, loginButton);
        layout.setStyle("-fx-padding: 20;");
        Scene scene = new Scene(layout, 300, 200);

        // Login button logic
        loginButton.setOnAction(e -> {
            String username = userField.getText();
            String password = passField.getText();

            // Check for correct credentials
            if (username.equals("admin") && password.equals("admin")) {
                AdminDashboard.show(primaryStage); // Open admin panel
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid login");
                alert.showAndWait();
            }
        });

        // Window settings
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX app
    }
}
