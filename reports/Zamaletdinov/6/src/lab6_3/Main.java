public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(365, "1111");
        atm.insertCard();
        atm.enterPIN_code("1111");
        atm.withdrawMoney(310);
        atm.enterPIN_code("1111");
        atm.withdrawMoney(100);
        atm.getCard();
    }
}