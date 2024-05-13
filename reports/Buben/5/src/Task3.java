
public class Task3 {
    public static void exec() {
        Client client = new Client("Иванов", 30, "ул. Пушкина, д.10");

        Account account = new Account("1234567890", 1000.0);
        client.setAccount(account);

        CreditCard creditCard = new CreditCard("9876543210", account, 5000.0);
        client.setCreditCard(creditCard);

        Order order = new Order("Z123", 500.0);

        client.payOrder(order);
        client.payOrder(order);

        Account otherAccount = new Account("0987654321", 2000.0);
        client.makePayment(otherAccount, 300.0);
        client.makePayment(otherAccount, 300.0);

        Administrator administrator = new Administrator("Сергей", 28, "ул. Пушкина, д.16");
        administrator.blockCreditCard(creditCard);

        client.payOrder(order);

        client.blockCreditCard();

        client.cancelAccount();
        client.payOrder(order);
    }
}
