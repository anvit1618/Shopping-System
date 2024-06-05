package order;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import auth.User;
import catalog.Product;
import catalog.ProductFactory;

public class OrderProcessorTest {

    private OrderProcessor orderProcessor;
    private ShoppingCart cart;
    private Product product;
    private User user;

    @Before
    public void setUp() {
        user = new User("testuser", "password");
        cart = ShoppingCart.getInstance();
        product = ProductFactory.createProduct("electronics", "E001", "Smartphone", 699.99, "Latest model", "path/to/image");
        cart.addItem(product, 1);
        orderProcessor = new OrderProcessor(user, cart);
    }

    @Test
    public void testProcessOrder() {
        orderProcessor.processOrder();
        assertTrue(cart.getItems().isEmpty());
    }
}
