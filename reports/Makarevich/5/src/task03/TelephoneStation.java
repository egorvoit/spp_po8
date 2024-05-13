package task03;

import java.util.ArrayList;
import java.util.List;

public class TelephoneStation {
    private List<Subscriber> subscribers;
    private List<Service> services;
    private List<Administrator> administrators;
    private List<Bill> bills;

    public TelephoneStation() {
        subscribers = new ArrayList<>();
        services = new ArrayList<>();
        administrators = new ArrayList<>();
        bills = new ArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Administrator> getAdministrators() {
        return administrators;
    }

    public void changeSubscriberNumber(Administrator admin, Subscriber subscriber, String newNumber) {
        if (administrators.contains(admin) && subscribers.contains(subscriber)) {
            admin.changeSubscriberNumber(subscriber, newNumber);
        } else {
            System.out.println("Ошибка: Администратор или абонент не найдены");
        }
    }

    public void temporarilyDisableSubscriber(Administrator admin, Subscriber subscriber) {
        if (administrators.contains(admin) && subscribers.contains(subscriber)) {
            admin.temporarilyDisableSubscriber(subscriber);
        } else {
            System.out.println("Ошибка: Администратор или абонент не найдены");
        }
    }

    public void manageServices(Administrator admin, Subscriber subscriber, Service service, boolean add) {
        if (administrators.contains(admin) && subscribers.contains(subscriber)) {
            admin.manageServices(subscriber, service, add);
        } else {
            System.out.println("Ошибка: Администратор или абонент не найдены");
        }
    }
}
