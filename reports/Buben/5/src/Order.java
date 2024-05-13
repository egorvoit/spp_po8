public class Order {
    private String orderNumber;
    private double orderAmount;
    private boolean isPayed;

    public Order(String orderNumber, double orderAmount) {
        this.orderNumber = orderNumber;
        this.orderAmount = orderAmount;
        this.isPayed = false;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void ConfirmOrder() {
        this.isPayed = true;
    }

    public boolean isPayed() {
        return isPayed;
    }
}
