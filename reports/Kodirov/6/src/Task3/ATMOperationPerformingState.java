package Task3;

public class ATMOperationPerformingState implements ATMState {
    private final ATM atm;

    public ATMOperationPerformingState(ATM atm) {
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
        System.out.println("Пин-код уже введен!");
    }

    @java.lang.Override
    public void requestCash(int cashAmount) {
        if (cashAmount > atm.getTotalCash()) {
            System.out.println("Недостаточно средств на карте!");
            atm.setCurrentState(new ATMBlockingState(atm));
            return;
        }
        int remainingCash = atm.getTotalCash() - cashAmount;
        atm.setTotalCash(remainingCash);
        System.out.println("Операция выполнена. Снято " + remainingCash);
    }
}
