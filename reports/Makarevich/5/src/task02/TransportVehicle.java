package task02;

public abstract class TransportVehicle {
    protected String name;
    protected int passengersCapacity;
    protected int cargoCapacity;

    public TransportVehicle(String name, int passengersCapacity, int cargoCapacity) {
        this.name = name;
        this.passengersCapacity = passengersCapacity;
        this.cargoCapacity = cargoCapacity;
    }

    public abstract double calculateTime(double distance);

    public abstract double calculateCost(double distance, double cargoWeight);
}