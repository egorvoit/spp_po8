public class AuthState implements StateOfATM{
    private final ATM atm;

    public AuthState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card already inserted!");
        atm.setState(new AuthState(atm));
    }

    public void enterPIN_code(String pinCode) {
        if (pinCode.equals(atm.PIN_code)) {
            System.out.println("PIN correct. You can now withdraw cash.");
            atm.setState(new TransactionState(atm));
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    public void withdrawMoney(int cashAmount) {
        System.out.println("Please enter your PIN first!");
    }

    public void getCard() {
        System.out.println("Card ejected!");
    }
}
