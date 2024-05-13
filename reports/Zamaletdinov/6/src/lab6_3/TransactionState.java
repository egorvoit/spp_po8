public class TransactionState implements StateOfATM{
    private final ATM atm;

    public TransactionState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card already inserted!");
        atm.setState(new AuthState(atm));
    }

    public void enterPIN_code(String pinCode) {
        System.out.println("PIN already entered");
    }

    public void withdrawMoney(int cashAmount) {
        if (cashAmount > atm.getAmountOfMoney()) {
            System.out.println("Insufficient funds!");
            atm.setState(new BlockState(atm));
            return;
        }
        atm.setAmountOfMoney(atm.getAmountOfMoney() - cashAmount);
        System.out.println("Withdrew " + cashAmount + " from your account.");
    }

    public void getCard() {
        System.out.println("Card ejected!");
        atm.setState(new WaitingState(atm));
    }
}
