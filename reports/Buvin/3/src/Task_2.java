import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Bus {
    private String driverName;
    private String busNumber;
    private int routeNumber;
    private String brand;
    private int yearOfOperation;
    private double mileage;
    private String location;

    public Bus(String driverName, String busNumber, int routeNumber, String brand, int yearOfOperation, double mileage, String location) {
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeNumber = routeNumber;
        this.brand = brand;
        this.yearOfOperation = yearOfOperation;
        this.mileage = mileage;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "driverName='" + driverName + '\'' +
                ", busNumber=" + busNumber +
                ", routeNumber=" + routeNumber +
                ", brand='" + brand + '\'' +
                ", yearOfOperation=" + yearOfOperation +
                ", mileage=" + mileage +
                ", location='" + location + '\'' +
                '}';
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public int getYearOfOperation() {
        return yearOfOperation;
    }

    public double getMileage() {
        return mileage;
    }

    public String getLocation() {
        return location;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}

public class Task_2 {
    private List<Bus> buses;

    public Task_2() {
        this.buses = new ArrayList<>();
    }

    public void readFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                buses.add(parseBusData(data));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    private Bus parseBusData(String[] data) {
        String driverName = data[0];
        String busNumber = data[1];
        int routeNumber = Integer.parseInt(data[2]);
        String brand = data[3];
        int yearOfOperation = Integer.parseInt(data[4]);
        double mileage = Double.parseDouble(data[5]);
        String location = data[6];
        return new Bus(driverName, busNumber, routeNumber, brand, yearOfOperation, mileage, location);
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public List<Bus> getBusesOnRoute() {
        return getBusesByLocation("маршрут");
    }

    public List<Bus> getBusesInPark() {
        return getBusesByLocation("парк");
    }

    private List<Bus> getBusesByLocation(String location) {
        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getLocation().equalsIgnoreCase(location)) {
                filteredBuses.add(bus);
            }
        }
        return filteredBuses;
    }

    public List<Bus> getBusesByRouteNumber(int routeNumber) {
        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getRouteNumber() == routeNumber) {
                filteredBuses.add(bus);
            }
        }
        return filteredBuses;
    }

    public List<Bus> getBusesMoreThanTenYearsInOperation() {
        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (2024 - bus.getYearOfOperation() > 10) {
                filteredBuses.add(bus);
            }
        }
        return filteredBuses;
    }

    public List<Bus> getBusesWithMileageMoreThanHundredThousand() {
        List<Bus> filteredBuses = new ArrayList<>();
        for (Bus bus : buses) {
            if (bus.getMileage() > 100000) {
                filteredBuses.add(bus);
            }
        }
        return filteredBuses;
    }

    public static void main(String[] args) {
        Task_2 busPark = new Task_2();
        busPark.readFromFile("buses.txt");

        System.out.println("Список всех автобусов:");
        for (Bus bus : busPark.getBuses()) {
            System.out.println(bus);
            System.out.println("Driver Name: " + bus.getDriverName());
            System.out.println("Bus Number: " + bus.getBusNumber());
            System.out.println("Route Number: " + bus.getRouteNumber());
            System.out.println("Brand: " + bus.getBrand());
            System.out.println("Year of Operation: " + bus.getYearOfOperation());
            System.out.println("Mileage: " + bus.getMileage());
            System.out.println("Location: " + bus.getLocation());
            System.out.println();
        }
    }
}