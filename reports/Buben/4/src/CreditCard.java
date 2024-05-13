public class CreditCard {
    private double creditLimit;
    private double currentDebt;
    private boolean blocked;

    public CreditCard(double creditLimit) {
        this.creditLimit = creditLimit;
        this.currentDebt = 0;
        this.blocked = false;
    }

    public void block() {
        this.blocked = true;
    }

    public void unblock() {
        this.blocked = false;
        System.out.println("Карта разблокирована");
    }

    public double getAvailableCredit() {
        return creditLimit - currentDebt;
    }

    public void increaseDebt(double amount) {
        currentDebt += amount;
    }


    public boolean isBlocked() {
        return blocked;
    }

    public double getCurrentDebt(){
        return currentDebt;
    }

    public double getCreditLimit(){
        return creditLimit;
    }
}
