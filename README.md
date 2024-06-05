# Shopping System Project

A comprehensive shopping system application implemented in Java using SOLID principles and various design patterns.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Usage Instructions](#usage-instructions)
- [Design Patterns](#design-patterns)
- [Code Snippets](#code-snippets)
- [Future Enhancements](#future-enhancements)

## Overview

This project aims to create a user-friendly shopping system that allows users to browse and purchase products. The application uses various design patterns such as Singleton, Factory, and Builder, and follows SOLID principles.

## Features

- User authentication
- Product catalog browsing
- Shopping cart functionality
- Payment processing simulation
- Logging of important events and transactions

## Project Structure

```
shoppingsystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── auth/
│   │   │   ├── catalog/
│   │   │   ├── gui/
│   │   │   ├── order/
│   │   │   ├── payment/
│   │   │   ├── utils/
│   ├── resources/
│   │   ├── images/
│   │   ├── products.csv
│   │   ├── users.csv
├── pom.xml
```

## Setup Instructions

### Prerequisites

- Java JDK 17
- Maven
- Git

### Clone the Repository

```bash
git clone https://github.com/anvit1618/Shopping-System.git
cd shoppingsystem
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn javafx:run
```

## Usage Instructions

1. **Login**: Use the login page to enter your credentials.
2. **Browse Products**: View the product catalog and select items to add to your cart.
3. **Add to Cart**: Add products to your shopping cart.
4. **View Cart**: Review items in your cart.
5. **Checkout**: Proceed to checkout and simulate payment.

## Design Patterns

### Singleton Pattern

Used in `AuthService` and `ShoppingCart`.

```java
public class AuthService {
    private static AuthService instance;

    private AuthService() {}

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }
}
```

### Factory Pattern

Used in `ProductFactory` for creating product instances.

```java
public class ProductFactory {
    public static Product createProduct(String category, String id, String name, double price, String description, String imagePath) {
        switch (category) {
            case "electronics":
                return new Electronics(id, name, price, description, imagePath);
            case "clothing":
                return new Clothing(id, name, price, description, imagePath);
            // Other categories...
        }
        return null;
    }
}
```

### Builder Pattern

Used for constructing complex objects like `ShoppingCart`.

```java
public class ShoppingCart {
    private Map<Product, Integer> items = new HashMap<>();

    public void addItem(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    // Other methods...
}
```

## Code Snippets

### AuthService

```java
public class AuthService {
    private static AuthService instance;
    private Map<String, User> users;

    private AuthService() {
        users = new HashMap<>();
        loadUsers();
    }

    public static AuthService getInstance() {
        if (instance == null) {
            instance = new AuthService();
        }
        return instance;
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    private void loadUsers() {
        List<Map<String, String>> userList = CsvUtils.readCsv("src/main/resources/users.csv");
        for (Map<String, String> userData : userList) {
            String username = userData.get("username");
            String password = userData.get("password");
            users.put(username, new User(username, password));
        }
    }
}
```

### Product

```java
public abstract class Product {
    protected String id;
    protected String name;
    protected double price;
    protected String description;
    protected String imagePath;
    protected String category;

    // Getters and constructor...
}
```

### CsvUtils

```java
public class CsvUtils {
    public static List<Map<String, String>> readCsv(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(",");
                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Map<String, String> map = new HashMap<>();
                    for (int i = 0; i < headers.length; i++) {
                        map.put(headers[i], values[i]);
                    }
                    data.add(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
```

## Future Enhancements

- Adding more product categories
- Implementing a database for better data persistence
- Enhancing the user interface with more features
- Adding real payment gateway integration
- Improving performance and scalability
