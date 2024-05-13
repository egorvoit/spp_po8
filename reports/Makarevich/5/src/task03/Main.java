package task03;

public class Main {
    public static void main(String[] args) {
        TelephoneStation station = new TelephoneStation();

        Subscriber subscriber1 = new Subscriber("123456789");
        Subscriber subscriber2 = new Subscriber("987654321");

        Service service1 = new Service("Internet", 25.0);
        Service service2 = new Service("Call Forwarding", 10.0);

        Administrator admin = new Administrator("John Doe");

        station.addSubscriber(subscriber1);
        station.addSubscriber(subscriber2);
        station.addService(service1);
        station.addService(service2);
        station.addAdministrator(admin);

        station.manageServices(admin, subscriber1, service1, true);
        station.manageServices(admin, subscriber2, service2, true);

        station.changeSubscriberNumber(admin, subscriber1, "987654321");

        station.temporarilyDisableSubscriber(admin, subscriber1);

        System.out.println("Телефонная станция:");
        System.out.println("Список абонентов: " + station.getSubscribers());
        System.out.println("Список услуг: " + station.getServices());
        System.out.println("Список администраторов: " + station.getAdministrators());
        System.out.println();
    }
}
