public class WaitingState implements StateOfATM {
    private final ATM atm;

    public WaitingState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("Card inserted");
        atm.setState(new AuthState(atm));
    }

    public void enterPIN_code(String pinCode) {
        System.out.println("Please insert your card first!");
    }

    public void withdrawMoney(int cashAmount) {
        System.out.println("Please insert your card first!");
    }

    public void getCard() {
        System.out.println("No card to eject!");
    }
}
