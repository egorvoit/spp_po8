public class CreditCard {
    private String cardNumber;
    private double creditLimit;
    private Account account;
    private boolean isBlocked;

    public CreditCard(String cardNumber, Account account, double creditLimit) {
        this.cardNumber = cardNumber;
        this.account = account;
        this.creditLimit = creditLimit;
        this.isBlocked = false;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    @SuppressWarnings("unused")
    public double getCreditLimit() {
        return creditLimit;
    }

    public Account getAccount() {
        return (!this.isBlocked) ? account : null;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}
