public class task3 {
    public static void main(String[] args) {
        ATM atm = new ATM(100, 1);
        BankCard card = new BankCard(1234, 150);
        atm.insertCard(card);
        atm.enterPinCode(1234);
        atm.requestCash(50);
        atm.requestCash(60);
        atm.ejectCard();
    }
}