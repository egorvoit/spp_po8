public class BankCard {
    private int pinCode;
    private int balance;
    BankCard(int _pinCode, int _balance) {
        this.pinCode = _pinCode;
        this.balance = _balance;
    }
    public Boolean checkPinCode(int _pinCode) {
        return this.pinCode == _pinCode;
    }
    public Boolean checkBalance(int _balance) {
        return this.balance>_balance;
    }
}
