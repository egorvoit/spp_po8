
public class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean pay(double amount) {
        if (this.balance - amount < 0) {
            return false;
        }

        this.balance -= amount;
        return true;
    }
}
