package order;

import java.util.HashMap;
import java.util.Map;

import catalog.Product;

public class ShoppingCart {

    private static ShoppingCart instance;
    private Map<Product, Integer> items;

    private ShoppingCart() {
        items = new HashMap<>();
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeItem(Product product, int quantity) {
        if (items.containsKey(product)) {
            int currentQuantity = items.get(product);
            if (currentQuantity <= quantity) {
                items.remove(product);
            } else {
                items.put(product, currentQuantity - quantity);
            }
        }
    }

    public void clearCart() {
        items.clear();
    }

    public Map<Product, Integer> getItems() {
        return items;
    }
}
