package catalog;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

public class ProductFactoryTest {

    @Test
    public void testCreateElectronicsProduct() {
        Product product = ProductFactory.createProduct("electronics", "E001", "Smartphone", 699.99, "Latest model", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Electronics);
        assertEquals("E001", product.getId());
    }

    @Test
    public void testCreateClothingProduct() {
        Product product = ProductFactory.createProduct("clothing", "C001", "T-Shirt", 19.99, "Cotton T-Shirt", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Clothing);
        assertEquals("C001", product.getId());
    }

    @Test
    public void testCreateGroceriesProduct() {
        Product product = ProductFactory.createProduct("groceries", "G001", "Apple", 1.99, "Fresh apple", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Groceries);
        assertEquals("G001", product.getId());
    }

    @Test
    public void testCreateHousewareProduct() {
        Product product = ProductFactory.createProduct("houseware", "H001", "Vacuum Cleaner", 129.99, "High power vacuum cleaner", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Houseware);
        assertEquals("H001", product.getId());
    }

    @Test
    public void testCreateKitchenwareProduct() {
        Product product = ProductFactory.createProduct("kitchenware", "K001", "Blender", 49.99, "Multi-function blender", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Kitchenware);
        assertEquals("K001", product.getId());
    }

    @Test
    public void testCreateFurnitureProduct() {
        Product product = ProductFactory.createProduct("furniture", "F001", "Sofa", 499.99, "Comfortable sofa", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Furniture);
        assertEquals("F001", product.getId());
    }

    @Test
    public void testCreateHealthProductsProduct() {
        Product product = ProductFactory.createProduct("healthproducts", "HP001", "Vitamins", 29.99, "Daily vitamins", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof HealthProducts);
        assertEquals("HP001", product.getId());
    }

    @Test
    public void testCreateBeautyProductsProduct() {
        Product product = ProductFactory.createProduct("beautyproducts", "BP001", "Shampoo", 9.99, "Nourishing shampoo", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof BeautyProducts);
        assertEquals("BP001", product.getId());
    }

    @Test
    public void testCreateToolsProduct() {
        Product product = ProductFactory.createProduct("tools", "T001", "Drill", 89.99, "Electric drill", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof Tools);
        assertEquals("T001", product.getId());
    }

    @Test
    public void testCreatePetCareProduct() {
        Product product = ProductFactory.createProduct("petcare", "PC001", "Dog Food", 19.99, "Healthy dog food", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof PetCare);
        assertEquals("PC001", product.getId());
    }

    @Test
    public void testCreateBathroomThingsProduct() {
        Product product = ProductFactory.createProduct("bathroomthings", "BT001", "Toothbrush", 4.99, "Electric toothbrush", "path/to/image");
        assertNotNull(product);
        assertTrue(product instanceof BathroomThings);
        assertEquals("BT001", product.getId());
    }
}
