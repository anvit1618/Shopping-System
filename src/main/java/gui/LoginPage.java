package gui;

import auth.AuthService;
import auth.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage {

    public Scene getLoginScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Username Label
        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);

        // Username Input
        TextField usernameInput = new TextField();
        usernameInput.setPromptText("username");
        GridPane.setConstraints(usernameInput, 1, 0);

        // Password Label
        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);

        // Password Input
        PasswordField passwordInput = new PasswordField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput, 1, 1);

        // Login Button
        Button loginButton = new Button("Login");
        GridPane.setConstraints(loginButton, 1, 2);
        loginButton.setOnAction(e -> {
            AuthService authService = AuthService.getInstance();
            User user = authService.login(usernameInput.getText(), passwordInput.getText());
            if (user != null) {
                primaryStage.setScene(CatalogPage.getCatalogScene(primaryStage, user));
            } else {
                // Show login error message
                Label errorLabel = new Label("Invalid username or password");
                GridPane.setConstraints(errorLabel, 1, 4);
                grid.getChildren().add(errorLabel);
            }
        });

        // Register Button
        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 3);
        registerButton.setOnAction(e -> primaryStage.setScene(new RegisterPage().getRegisterScene(primaryStage)));

        // Add everything to grid
        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, loginButton, registerButton);

        return new Scene(grid, 300, 200);
    }
}
