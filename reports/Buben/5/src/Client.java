
public class Client extends Human {
    @SuppressWarnings("unused")
    private Account account;
    private CreditCard creditCard;

    public Client(String name, int age, String address) {
        super(name, age, address);
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public void payOrder(Order order) {
        Account acc;
        if (this.creditCard != null) {
            acc = this.creditCard.getAccount();
        } else if (this.account != null) {
            acc = this.account;
        } else {
            System.out.println("У клиента " + name + " нет счета");
            return;
        }

        if (acc == null) {
            System.out.println("Карточка клиента " + this.name + " заблокирована!");
            return;
        }

        if (order.isPayed()) {
            System.out.println("Заказ №" + order.getOrderNumber() + " уже оплачен");
            return;
        }

        if (!acc.pay(order.getOrderAmount())) {
            System.out.println("Нехватает баланса");
            return;
        }
        order.ConfirmOrder();

        System.out.println("Оплата заказа " + order.getOrderNumber() + " клиентом " + this.name);
    }

    public void makePayment(Account targetAccount, double amount) {
        Account acc;
        if (this.creditCard != null) {
            acc = this.creditCard.getAccount();
        } else if (this.account != null) {
            acc = this.account;
        } else {
            System.out.println("У клиента " + name + " нет счета");
            return;
        }

        if (acc == null) {
            System.out.println("Карточка клиента " + this.name + " заблокирована!");
            return;
        }

        if (!acc.pay(amount)) {
            System.out.println("Нехватает баланса");
            return;
        }
        targetAccount.pay(-amount);

        System.out.println("Выполнение платежа на счет " + targetAccount.getAccountNumber() + " в размере " + amount);
    }

    public void blockCreditCard() {
        this.creditCard.setBlocked(true);
        System.out.println("Блокировка кредитной карты клиента " + name);
    }

    public void cancelAccount() {
        this.account = null;
        this.creditCard = null;

        System.out.println("Аннулирование счета клиента " + name);
    }
}
