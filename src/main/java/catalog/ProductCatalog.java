package catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.CsvUtils;

public class ProductCatalog {
    private final List<Product> products;

    public ProductCatalog() {
        products = new ArrayList<>();
        loadProducts();
    }

    private void loadProducts() {
        List<Map<String, String>> productList = CsvUtils.readCsv("src/main/resources/products.csv");
        for (Map<String, String> productData : productList) {
            String category = productData.get("category");
            String id = productData.get("id");
            String name = productData.get("name");
            double price = Double.parseDouble(productData.get("price"));
            String description = productData.get("description");
            String imagePath = productData.get("imagePath");
            Product product = ProductFactory.createProduct(category, id, name, price, description, imagePath);
            products.add(product);
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}
