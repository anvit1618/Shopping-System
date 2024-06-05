package gui;

import java.util.Map;

import auth.User;
import catalog.Product;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import order.ShoppingCart;

public class CartPage {

    public static Scene getCartScene(Stage primaryStage, User user) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        ShoppingCart cart = ShoppingCart.getInstance();
        ListView<String> cartList = new ListView<>();
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            cartList.getItems().add(entry.getKey().getName() + " x " + entry.getValue());
        }
        GridPane.setConstraints(cartList, 0, 0);

        Button removeButton = new Button("Remove");
        GridPane.setConstraints(removeButton, 0, 1);
        removeButton.setOnAction(e -> {
            String selectedItem = cartList.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                String productName = selectedItem.split(" x ")[0];
                Product product = cart.getItems().keySet().stream()
                        .filter(p -> p.getName().equals(productName))
                        .findFirst().orElse(null);
                if (product != null) {
                    cart.removeItem(product, 1); // Specify the quantity to remove
                    cartList.getItems().remove(selectedItem);
                    // Update the list after removal
                    cartList.getItems().clear();
                    for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
                        cartList.getItems().add(entry.getKey().getName() + " x " + entry.getValue());
                    }
                }
            }
        });

        Button checkoutButton = new Button("Checkout");
        GridPane.setConstraints(checkoutButton, 1, 1);
        checkoutButton.setOnAction(e -> primaryStage.setScene(CheckoutPage.getCheckoutScene(primaryStage, user)));

        Button backButton = new Button("Back");
        GridPane.setConstraints(backButton, 2, 1);
        backButton.setOnAction(e -> primaryStage.setScene(CatalogPage.getCatalogScene(primaryStage, user)));

        grid.getChildren().addAll(cartList, removeButton, checkoutButton, backButton);

        return new Scene(grid, 800, 600);
    }
}
