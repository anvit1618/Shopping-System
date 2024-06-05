package gui;

import auth.User;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import order.ShoppingCart;
import order.OrderProcessor;
import payment.MockPaymentGateway;
import payment.PaymentService;

public class CheckoutPage {

    public static Scene getCheckoutScene(Stage primaryStage, User user) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        Label messageLabel = new Label("");
        GridPane.setConstraints(messageLabel, 0, 0);

        Button confirmButton = new Button("Confirm Payment");
        GridPane.setConstraints(confirmButton, 0, 1);
        confirmButton.setOnAction(e -> {
            PaymentService paymentService = new PaymentService(new MockPaymentGateway());
            boolean success = paymentService.processPayment(100); // Example amount
            if (success) {
                OrderProcessor orderProcessor = new OrderProcessor(user, ShoppingCart.getInstance());
                orderProcessor.placeOrder();
                messageLabel.setText("Payment successful and order placed!");
            } else {
                messageLabel.setText("Payment failed.");
            }
        });

        Button cancelButton = new Button("Cancel");
        GridPane.setConstraints(cancelButton, 1, 1);
        cancelButton.setOnAction(e -> primaryStage.setScene(CatalogPage.getCatalogScene(primaryStage, user)));

        grid.getChildren().addAll(messageLabel, confirmButton, cancelButton);

        return new Scene(grid, 300, 200);
    }
}
