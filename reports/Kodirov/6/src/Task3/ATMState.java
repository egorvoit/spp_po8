package Task3;

interface ATMState {
    void insertCard();
    void ejectCard();
    void enterPinCode(int pinCode);
    void requestCash(int cashAmount);
}
