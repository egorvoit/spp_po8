import java.util.ArrayList;
import java.util.List;

public class Payment {
    private int orderId;
    private List<Item> items;

    public Payment(int orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        items.add(new Item(name, price, quantity));
    }

    public double calculateTotalAmount() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    public void displayItems() {
        for (Item item : items) {
            System.out.println("Item: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
        }
    }

    private class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public static void main(String[] args) {
        Payment payment = new Payment(12345);
        payment.addItem("Product 1", 10.99, 2);
        payment.addItem("Product 2", 15.49, 1);

        payment.displayItems();
        System.out.println("Total: $" + payment.calculateTotalAmount());
    }
}