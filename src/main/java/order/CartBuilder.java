package order;

import catalog.Product;

public class CartBuilder {
    private ShoppingCart cart;

    public CartBuilder() {
        cart = ShoppingCart.getInstance();
    }

    public CartBuilder addItem(Product product, int quantity) {
        cart.addItem(product, quantity);
        return this;
    }

    public CartBuilder removeItem(Product product, int quantity) {
        cart.removeItem(product, quantity);
        return this;
    }

    public ShoppingCart build() {
        return cart;
    }
}
