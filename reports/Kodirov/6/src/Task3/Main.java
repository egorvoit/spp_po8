package Task3;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM(100);
        atm.insertCard();
        atm.enterPinCode(1234);
        atm.requestCash(50);
        atm.requestCash(60);
        atm.ejectCard();
    }
}
