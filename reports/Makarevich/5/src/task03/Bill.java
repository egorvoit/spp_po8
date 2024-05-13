package task03;

public class Bill {
    private double amount;

    public Bill(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void payBill(double amount) {
        // Логика оплаты счета
        System.out.println("Счет в размере " + amount + " оплачен");
    }
}
