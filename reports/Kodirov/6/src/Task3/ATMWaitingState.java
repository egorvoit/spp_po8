package Task3;

public class ATMWaitingState implements ATMState {
    private final ATM atm;

    public ATMWaitingState(ATM atm) {
        this.atm = atm;
    }

    @java.lang.Override
    public void insertCard() {
        System.out.println("Карта вставлена!");
        atm.setCurrentState(new ATMAuthenticationState(atm));
    }

    @java.lang.Override
    public void ejectCard() {
        System.out.println("Невозможно извлечь карту - карта не вставлена!");
    }

    @java.lang.Override
    public void enterPinCode(int pinCode) {
        System.out.println("Карта не вставлена!");
    }

    @java.lang.Override
    public void requestCash(int cashAmount) {
        System.out.println("Вставьте сначала карту и введите пин-код!");
    }
}
