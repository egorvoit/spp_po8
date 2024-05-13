package Task3;

public class ATMAuthenticationState implements ATMState {
    private final ATM atm;

    public ATMAuthenticationState(ATM atm) {
        this.atm = atm;
    }

    @java.lang.Override
    public void insertCard() {
        System.out.println("Карта уже вставлена!");
    }

    @java.lang.Override
    public void ejectCard() {
        System.out.println("Карта извлечена!");
        atm.setCurrentState(new ATMWaitingState(atm));
    }

    @java.lang.Override
    public void enterPinCode(int pinCode) {
        System.out.println("Пин-код введен!");
        atm.setCurrentState(new ATMOperationPerformingState(atm));
    }

    @java.lang.Override
    public void requestCash(int cashAmount) {
        System.out.println("Введите сначала пин-код!");
    }
}
