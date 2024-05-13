public class ATMBlockingState implements ATMState {
    private final ATM atm;

    public ATMBlockingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard() {
        System.out.println("ATM is blocked!");
    }

    @Override
    public void extractCard() {
        System.out.println("ATM is blocked, Card extracted!");
        atm.setCurrentState(new ATMWaitingState(atm));
    }

    @Override
    public void enterPinCode() {
        System.out.println("ATM is blocked!");
    }

    @Override
    public void requestCash(int cashAmount) {
        System.out.println("ATM is blocked!");
    }
}
