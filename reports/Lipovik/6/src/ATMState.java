interface ATMState {
    void insertCard();
    void extractCard();
    void enterPinCode();
    void requestCash(int cashAmount);
}
