package order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import catalog.Product;
import catalog.ProductFactory;

public class ShoppingCartTest {

    private ShoppingCart cart;
    private Product product;

    @Before
    public void setUp() {
        cart = ShoppingCart.getInstance();
        product = ProductFactory.createProduct("electronics", "E001", "Smartphone", 699.99, "Latest model", "path/to/image");
    }

    @Test
    public void testAddItem() {
        cart.addItem(product, 1);
        assertEquals(1, cart.getItems().get(product).intValue());
    }

    @Test
    public void testRemoveItem() {
        cart.addItem(product, 1);
        cart.removeItem(product, 1);
        assertFalse(cart.getItems().containsKey(product));
    }

    @Test
    public void testClearCart() {
        cart.addItem(product, 1);
        cart.clearCart();
        assertTrue(cart.getItems().isEmpty());
    }
}
