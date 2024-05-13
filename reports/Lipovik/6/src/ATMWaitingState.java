public class ATMWaitingState implements ATMState {
    private final ATM atm;

    public ATMWaitingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("The card is already inserted!");
        atm.setCurrentState(new ATMAuthenticationState(atm));
    }

    @Override
    public void extractCard() {
        System.out.println("Cannot remove card - card not inserted!");
    }

    @Override
    public void enterPinCode() {
        System.out.println("Card not inserted!");
    }

    @Override
    public void requestCash(int cashAmount) {
        System.out.println("First insert the card and enter the PIN code!");
    }
}
