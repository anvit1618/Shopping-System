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

public class RegisterPage {

    private AuthService authService = AuthService.getInstance();

    public Scene getRegisterScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label usernameLabel = new Label("Username:");
        GridPane.setConstraints(usernameLabel, 0, 0);
        TextField usernameInput = new TextField();
        GridPane.setConstraints(usernameInput, 1, 0);

        Label passwordLabel = new Label("Password:");
        GridPane.setConstraints(passwordLabel, 0, 1);
        PasswordField passwordInput = new PasswordField();
        GridPane.setConstraints(passwordInput, 1, 1);

        Button registerButton = new Button("Register");
        GridPane.setConstraints(registerButton, 1, 2);
        registerButton.setOnAction(e -> {
            String username = usernameInput.getText();
            String password = passwordInput.getText();
            authService.register(new User(username, password));
            primaryStage.setScene(new LoginPage().getLoginScene(primaryStage));
        });

        grid.getChildren().addAll(usernameLabel, usernameInput, passwordLabel, passwordInput, registerButton);

        return new Scene(grid, 300, 200);
    }
}