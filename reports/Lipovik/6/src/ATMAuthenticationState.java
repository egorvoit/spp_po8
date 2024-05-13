public class ATMAuthenticationState implements ATMState {
    private final ATM atm;

    public ATMAuthenticationState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("The card is already inserted!");
    }

    @Override
    public void extractCard() {
        System.out.println("Card extracted!");
        atm.setCurrentState(new ATMWaitingState(atm));
    }

    @Override
    public void enterPinCode() {
        System.out.println("PIN code entered!");
        atm.setCurrentState(new ATMOperationPerformingState(atm));
    }

    @Override
    public void requestCash(int cashAmount) {
        System.out.println("Enter your PIN code first!");
    }
}
