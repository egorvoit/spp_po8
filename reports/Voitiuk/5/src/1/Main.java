interface Mobile {
    void call(String number);
    void sendMessage(String number, String message);
}

abstract class SamsungMobile implements Mobile {
    String model;

    public SamsungMobile(String model) {
        this.model = model;
    }

    @Override
    public void call(String number) {
        System.out.println("Звоним на номер " + number + " с телефона Samsung " + model);
    }

    @Override
    public void sendMessage(String number, String message) {
        System.out.println("Отправляем сообщение '" + message + "' на номер " + number + " с телефона Samsung " + model);
    }

    abstract void useSamsungPay();
}

class Model extends SamsungMobile {
    public Model(String model) {
        super(model);
    }

    @Override
    void useSamsungPay() {
        System.out.println("Оплата через Samsung Pay с телефона Samsung " + model);
    }
}

public class Main {
    public static void main(String[] args) {
        Model myPhone = new Model("Galaxy S20");

        myPhone.call("1234567890");
        myPhone.sendMessage("1234567890", "Привет!");

        myPhone.useSamsungPay();
    }
}

