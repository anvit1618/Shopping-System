package catalog;

public class Furniture extends Product {
    public Furniture(String id, String name, double price, String description, String imagePath) {
        super(id, name, price, description, imagePath, "Furniture");
    }
}
