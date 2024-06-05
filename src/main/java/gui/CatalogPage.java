package gui;

import auth.User;
import catalog.Product;
import catalog.ProductCatalog;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import order.ShoppingCart;

public class CatalogPage {

    public static Scene getCatalogScene(Stage primaryStage, User user) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        ProductCatalog catalog = new ProductCatalog();
        ListView<Product> productList = new ListView<>();
        productList.getItems().addAll(catalog.getProducts());
        GridPane.setConstraints(productList, 0, 0);

        ImageView productImageView = new ImageView();
        productImageView.setFitWidth(200);
        productImageView.setFitHeight(200);
        GridPane.setConstraints(productImageView, 1, 0);

        Button addToCartButton = new Button("Add to Cart");
        GridPane.setConstraints(addToCartButton, 0, 1);
        addToCartButton.setOnAction(e -> {
            Product selectedProduct = productList.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                ShoppingCart cart = ShoppingCart.getInstance();
                cart.addItem(selectedProduct, 1);
                System.out.println("Added to cart!");
            }
        });

        Button viewCartButton = new Button("View Cart");
        GridPane.setConstraints(viewCartButton, 1, 1);
        viewCartButton.setOnAction(e -> primaryStage.setScene(CartPage.getCartScene(primaryStage, user)));

        productList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                Image image = new Image(newValue.getImagePath());
                productImageView.setImage(image);
            }
        });

        grid.getChildren().addAll(productList, productImageView, addToCartButton, viewCartButton);

        return new Scene(grid, 800, 600);
    }
}
