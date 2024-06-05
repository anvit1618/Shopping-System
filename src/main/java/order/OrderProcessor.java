package order;

import java.util.Map;

import auth.User;
import catalog.Product;

public class OrderProcessor {
    private User user;
    private ShoppingCart cart;

    public OrderProcessor(User user, ShoppingCart cart) {
        this.user = user;
        this.cart = cart;
    }

    public void placeOrder() {
        // Process the order
        // This can include reducing stock, updating order history, etc.
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            System.out.println("Ordering " + entry.getValue() + " of " + entry.getKey().getName());
        }
        cart.clearCart(); // Clear the cart after placing the order
    }

    void processOrder() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
