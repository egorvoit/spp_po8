package task03;

public class Subscriber extends User {
    public Subscriber(String phoneNumber) {
        super(phoneNumber);
    }

    public void makeCall(String number) {
        System.out.println("Вызываем номер " + number);
    }

    public void requestServiceCancellation(Service service) {
        removeService(service);
        System.out.println("Абонент успешно отказался от услуги: " + service.getName());
    }

    @Override
    public String toString() {
        return "Абонент с номером " + getPhoneNumber();
    }
}
