public class Task3 {
    public static void main(String[] args) {
        Account account = new Account(1000);
        CreditCard creditCard = new CreditCard(2000);
        Client client = new Client("John", account, creditCard);
        Order order = new Order(500);
        client.makePayment(order);

        double debt = creditCard.getCurrentDebt();
        System.out.println("Текущий долг на карте: " + debt);

        Admin admin = new Admin();
        admin.blockCreditCardForExceedingCredit(creditCard);

        creditCard.unblock();

        Account otherAcc = new Account(0);
        client.transferMoney(200,otherAcc);
        double otherBalance = otherAcc.getBalance();
        System.out.println("Счет получателя: " + otherBalance);
        double balance = account.getBalance();
        System.out.println("Счет отправителя: " + balance);

    }
}


