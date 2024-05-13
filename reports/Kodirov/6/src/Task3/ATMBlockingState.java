package Task3;

public class ATMBlockingState implements ATMState {
    private final ATM atm;

    public ATMBlockingState(ATM atm) {
        this.atm = atm;
    }

    @java.lang.Override
    public void insertCard() {
        System.out.println("Банкомат заблокирован!");
    }

    @java.lang.Override
    public void ejectCard() {
        System.out.println("Банкомат разблокирован, карта извлечена!");
        atm.setCurrentState(new ATMWaitingState(atm));
    }

    @java.lang.Override
    public void enterPinCode(int pinCode) {
        System.out.println("Банкомат заблокирован!");
    }

    @java.lang.Override
    public void requestCash(int cashAmount) {
        System.out.println("Банкомат заблокирован!");
    }
}