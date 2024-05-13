public class ATMOperationPerformingState implements ATMState {
    private final ATM atm;

    public ATMOperationPerformingState(ATM atm) {
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
        System.out.println("PIN code has already been entered!");
    }

    @Override
    public void requestCash(int cashAmount) {
        int remainingCash = atm.getTotalCash() - cashAmount;
        atm.setTotalCash(remainingCash);
        System.out.println("The operation is completed. Removed " + remainingCash);
    }
}
