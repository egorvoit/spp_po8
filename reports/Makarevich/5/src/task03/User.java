package task03;

import java.util.ArrayList;
import java.util.List;

public abstract class User {
    protected String phoneNumber;
    protected List<Service> services;

    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.services = new ArrayList<>();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void changePhoneNumber(String newNumber) {
        this.phoneNumber = newNumber;
    }

    public void addService(Service service) {
        services.add(service);
    }

    public void removeService(Service service) {
        services.remove(service);
    }
}
