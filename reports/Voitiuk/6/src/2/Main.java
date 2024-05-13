import java.util.ArrayList;
import java.util.List;

interface AccountLevel {
    void applyDiscount();
}

class NewCustomer implements AccountLevel {
    public void applyDiscount() {
        System.out.println("Применяется скидка для новых клиентов");
    }
}

class RegularCustomer implements AccountLevel {
    public void applyDiscount() {
        System.out.println("Применяется скидка для постоянных клиентов");
    }
}

class PremiumCustomer implements AccountLevel {
    public void applyDiscount() {
        System.out.println("Применяется скидка для премиум-клиентов");
    }
}

class CustomerAccount {
    private AccountLevel level;
    private String name;
    private List<String> cart;

    public CustomerAccount(AccountLevel level, String name) {
        this.level = level;
        this.name = name;
        this.cart = new ArrayList<>();
    }

    public void setLevel(AccountLevel level) {
        this.level = level;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void addToCart(String item) {
        this.cart.add(item);
    }

    public void checkout() {
        System.out.println("Оформление заказа для " + name);
        for (String item : cart) {
            System.out.println("Товар: " + item);
        }
        cart.clear();
        level.applyDiscount();
    }
}

public class Main {
    public static void main(String[] args) {
        CustomerAccount account = new CustomerAccount(new NewCustomer(), "Иван");
        account.addToCart("Книга 1");
        account.addToCart("Книга 2");
        account.checkout();  // Оформление заказа для Иван

        account.setLevel(new RegularCustomer());
        account.addToCart("Книга 3");
        account.checkout();  // Оформление заказа для Иван

        account.setLevel(new PremiumCustomer());
        account.updateName("Алексей");
        account.addToCart("Книга 4");
        account.checkout();  // Оформление заказа для Алексей
    }
}
