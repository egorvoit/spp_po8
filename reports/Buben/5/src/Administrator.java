public class Administrator extends Human {
    public Administrator(String name, int age, String address) {
        super(name, age, address);
    }

    public void blockCreditCard(CreditCard card) {
        card.setBlocked(true);
        System.out.println("Блокировка кредитной карты " + card.getCardNumber() + " администратором " + name);
    }
}
