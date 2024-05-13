public class BlockState implements StateOfATM{
    private final ATM atm;

    public BlockState(ATM atm) {
        this.atm = atm;
    }

    public void insertCard() {
        System.out.println("ATM is blocked!");
        atm.setState(new AuthState(atm));
    }

    public void enterPIN_code(String pinCode) {
        System.out.println("ATM is blocked!");
    }

    public void withdrawMoney(int cashAmount) {
        System.out.println("ATM is blocked!");
    }

    public void getCard() {
        System.out.println("Card ejected! Come back later!");
        atm.setState(new WaitingState(atm));
    }
}
