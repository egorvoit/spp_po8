package task03;

public class Administrator {
    private String name;

    public Administrator(String name) {
        this.name = name;
    }

    public void changeSubscriberNumber(Subscriber subscriber, String newNumber) {
        subscriber.changePhoneNumber(newNumber);
        System.out.println("Номер абонента успешно изменен на " + newNumber);
    }

    public void temporarilyDisableSubscriber(Subscriber subscriber) {
        // Логика временного отключения абонента за неуплату
        System.out.println("Абонент " + subscriber.getPhoneNumber() + " временно отключен за неуплату");
    }

    public void manageServices(Subscriber subscriber, Service service, boolean add) {
        if (add) {
            subscriber.addService(service);
            System.out.println("Абоненту " + subscriber.getPhoneNumber() + " успешно подключена услуга: " + service.getName());
        } else {
            subscriber.removeService(service);
            System.out.println("Абонент отказался от услуги: " + service.getName());
        }
    }

    @Override
    public String toString() {
        return "Администратор " + name;
    }
}
