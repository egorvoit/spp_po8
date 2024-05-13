import java.util.ArrayList;
import java.util.List;

public class Payment {
    private List<Product> products;

    public Payment() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, double price) {
        Product product = new Product(name, price);
        products.add(product);
    }

    public double getFullCost() {
        double cost = 0;
        for (Product pr : products) {
            cost += pr.getPrice();
        }
        return cost;
    }

    public void printList() {
        System.out.println("Payment list:");
        for (Product pr : products) {
            System.out.println(pr.name + ": " + pr.price);
        }
    }

    public void removeProduct(String name) {
        products.removeIf(product -> product.name.equals(name));
    }

    private static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }
}


