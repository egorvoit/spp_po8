public class ATM {
    private int totalCash;
    private int ID;
    private BankCard card;
    private ATMState currentState;

    public ATM(int totalCash, int _ID) {
        this.totalCash = totalCash;
        this.ID = _ID;
        currentState = new ATMWaitingState(this);
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public void insertCard(BankCard _card) {
        this.card = _card;
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.extractCard();
    }

    public void enterPinCode(int pinCode) {
        if(!card.checkPinCode(pinCode)){
            System.out.println("Wrong PIN code!");
            return;
        }
        currentState.enterPinCode();
    }

    public void requestCash(int cashAmount) {
        if(!card.checkBalance(cashAmount)){
            System.out.println("Insufficient cash on card!");
            return;
        }
        if(cashAmount > totalCash){
            System.out.println("Insufficient cash in ATM!");
            return;
        }
        currentState.requestCash(cashAmount);
        if(totalCash==0){
            setCurrentState(new ATMBlockingState(this));
        }
    }

    public void setTotalCash(int totalCash) {
        this.totalCash = totalCash;
    }

    public int getTotalCash() {
        return totalCash;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
