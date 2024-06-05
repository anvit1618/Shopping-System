package catalog;

public class ProductFactory {
    public static Product createProduct(String category, String id, String name, double price, String description, String imagePath) {
        return switch (category.toLowerCase()) {
            case "electronics" -> new Electronics(id, name, price, description, imagePath);
            case "clothing" -> new Clothing(id, name, price, description, imagePath);
            case "groceries" -> new Groceries(id, name, price, description, imagePath);
            case "houseware" -> new Houseware(id, name, price, description, imagePath);
            case "kitchenware" -> new Kitchenware(id, name, price, description, imagePath);
            case "furniture" -> new Furniture(id, name, price, description, imagePath);
            case "healthproducts" -> new HealthProducts(id, name, price, description, imagePath);
            case "beautyproducts" -> new BeautyProducts(id, name, price, description, imagePath);
            case "tools" -> new Tools(id, name, price, description, imagePath);
            case "petcare" -> new PetCare(id, name, price, description, imagePath);
            case "bathroomthings" -> new BathroomThings(id, name, price, description, imagePath);
            default -> throw new IllegalArgumentException("Unknown product category: " + category);
        };
    }
}
