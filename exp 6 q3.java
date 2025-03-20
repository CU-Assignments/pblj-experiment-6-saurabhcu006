q3-
solution-import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}

public class ProductStreamProcessing {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.50));
        products.add(new Product("Phone", "Electronics", 799.99));
        products.add(new Product("TV", "Electronics", 1500.00));
        products.add(new Product("Shirt", "Clothing", 35.99));
        products.add(new Product("Jeans", "Clothing", 59.99));
        products.add(new Product("Socks", "Clothing", 5.99));
        products.add(new Product("Refrigerator", "Appliances", 900.00));
        products.add(new Product("Microwave", "Appliances", 250.00));

        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        // Display products grouped by category
        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        // Find the most expensive product in each category
        System.out.println("\nMost expensive product in each category:");
        productsByCategory.forEach((category, productList) -> {
            Product mostExpensiveProduct = productList.stream()
                    .max(Comparator.comparingDouble(Product::getPrice))
                    .orElseThrow(() -> new NoSuchElementException("No products found"));
            System.out.println(category + ": " + mostExpensiveProduct);
        });

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .collect(Collectors.averagingDouble(Product::getPrice));
        
        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}
