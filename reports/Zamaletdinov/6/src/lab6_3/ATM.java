public class ATM {
    public double amountOfMoney;
    public String PIN_code;
    public StateOfATM state;

    public ATM(double amountOfMoney, String PIN_code) {
        this.amountOfMoney = amountOfMoney;
        this.PIN_code = PIN_code;
        this.state = new WaitingState(this);
    }

    public void setState(StateOfATM state) {
        this.state = state;
    }

    public double getAmountOfMoney(){
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney){
        this.amountOfMoney = amountOfMoney;
    }

    public void insertCard(){
        state.insertCard();
    }

    public void enterPIN_code(String PIN_code){
        state.enterPIN_code(PIN_code);
    }

    public void withdrawMoney(int amountOfMoney){
        state.withdrawMoney(amountOfMoney);
    }

    public void getCard(){
        state.getCard();
    }
}
