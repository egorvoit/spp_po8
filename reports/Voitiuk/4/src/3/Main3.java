import java.util.ArrayList;
import java.util.List;

class Arrears {
    private double amount;

    public Arrears(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

class Service {
    private String name;
    private double price;

    public Service(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Subscriber {
    public String phoneNumber;
    public List<Service> services;
    public Arrears arrears;
    public boolean isActive;

    public Subscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.services = new ArrayList<>();
        this.arrears = new Arrears(0);
        this.isActive = true;
    }

    public void requestPhoneNumberChange(Administrator administrator, String newNumber) {
        administrator.changePhoneNumber(this, newNumber);
    }

    public void requestService(Administrator administrator, Service service) {
        administrator.requestService(this, service);
    }

    public void cancelService(Administrator administrator, Service service) {
        administrator.cancelService(this, service);
    }

    public void payArrears(double amount) {
        this.arrears.setAmount(this.arrears.getAmount() - amount);
        System.out.println("Абонент " + this.phoneNumber + " положил сумму" + amount + " на счет.");
        if(!this.isActive && !checkUnpaidArrears())
        {
            this.isActive = true;
            System.out.println
                    ("Абонент " + this.phoneNumber + " вновь подключен.");
        }
    }

    public void accountAmount()
    {
        if(checkUnpaidArrears())
        {
            System.out.println
                    ("У абонента " + this.phoneNumber + " имеется задолженность суммой " + this.arrears.getAmount());
        }
        else
        {
            System.out.println
                    ("У абонента " + this.phoneNumber + " имеется остаток на счете суммой " + (-this.arrears.getAmount()));
        }
    }

    public boolean checkUnpaidArrears() {
        return this.arrears.getAmount() > 0;
    }
}

class Administrator {
    public void changePhoneNumber(Subscriber subscriber, String newNumber) {
        System.out.println("Абонент с номером " + subscriber.phoneNumber + " сменил номер телефона на " + newNumber);
        subscriber.phoneNumber = newNumber;
    }

    public void requestService(Subscriber subscriber, Service service) {
        subscriber.services.add(service);
        subscriber.arrears.setAmount(subscriber.arrears.getAmount() + service.getPrice());
        System.out.println("Абонент " + subscriber.phoneNumber + " подписался на услугу: " + service.getName());
    }

    public void cancelService(Subscriber subscriber, Service service) {
        if (subscriber.services.contains(service)) {
            subscriber.services.remove(service);
            subscriber.arrears.setAmount(subscriber.arrears.getAmount() - service.getPrice());
            System.out.println("Абонент " + subscriber.phoneNumber + " отписался от услуги: " + service.getName());
        }
    }

    public void temporarilyDisableSubscriber(Subscriber subscriber) {
        if (subscriber.checkUnpaidArrears()) {
            subscriber.isActive = false;
            System.out.println("Абонент " + subscriber.phoneNumber + " отключен за неуплату.");
        }
    }
}

class TelephoneStation {
    private List<Subscriber> subscribers;

    public TelephoneStation() {
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }
}

public class Main3 {
    public static void main(String[] args) {
        TelephoneStation telephoneStation = new TelephoneStation();

        Service service1 = new Service("Интернет обслуживание", 34.0);
        Service service2 = new Service("Подписка на музыку", 89.0);
        Service service3 = new Service("Подписка на анекдоты", 15.0);
        Subscriber subscriber1 = new Subscriber("297228696");

        telephoneStation.addSubscriber(subscriber1);

        Administrator administrator = new Administrator();

        subscriber1.requestPhoneNumberChange(administrator, "336663432");

        subscriber1.payArrears(15);

        subscriber1.requestService(administrator, service1);
        subscriber1.requestService(administrator, service2);
        subscriber1.requestService(administrator, service3);

        subscriber1.accountAmount();

        subscriber1.cancelService(administrator, service2);

        administrator.temporarilyDisableSubscriber(subscriber1);

        subscriber1.payArrears(1000);

        subscriber1.accountAmount();


    }
}