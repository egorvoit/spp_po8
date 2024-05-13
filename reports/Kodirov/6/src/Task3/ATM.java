package Task3;

public class ATM {
    private int totalCash;
    private int pinCode;
    private ATMState currentState;

    public ATM(int totalCash) {
        this.totalCash = totalCash;
        currentState = new ATMWaitingState(this);
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPinCode(int pinCode) {
        this.pinCode = pinCode;
        currentState.enterPinCode(pinCode);
    }

    public void requestCash(int cashAmount) {
        currentState.requestCash(cashAmount);
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    public int getTotalCash() {
        return totalCash;
    }
}