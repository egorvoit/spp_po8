package task02;

public class Car extends TransportVehicle {
    private double speed;
    private double costPerKm;

    public Car(String name, int passengersCapacity, int cargoCapacity, double speed, double costPerKm) {
        super(name, passengersCapacity, cargoCapacity);
        this.speed = speed;
        this.costPerKm = costPerKm;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / speed;
    }

    @Override
    public double calculateCost(double distance, double cargoWeight) {
        return distance * costPerKm + cargoWeight * 0.1;
    }
}
