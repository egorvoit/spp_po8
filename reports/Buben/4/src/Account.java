public class Account {
    private double balance;
    private boolean active;

    public Account(double balance) {
        this.balance = balance;
        this.active = true;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Снято со счета: " + amount);
        } else {
            System.out.println("Недостаточно средств на счете.");
        }
    }

    public void cancel() {
        this.active = false;
        System.out.println("Счет аннулирован");
    }

    public double getBalance() {
        return balance;
    }
}







