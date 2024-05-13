public class Order {
    private double totalPrice;
    private boolean paid;

    public Order(double totalPrice) {
        this.totalPrice = totalPrice;
        this.paid = false;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
