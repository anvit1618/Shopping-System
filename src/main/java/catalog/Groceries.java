package catalog;

public class Groceries extends Product {
    public Groceries(String id, String name, double price, String description, String imagePath) {
        super(id, name, price, description, imagePath, "Groceries");
    }
}
