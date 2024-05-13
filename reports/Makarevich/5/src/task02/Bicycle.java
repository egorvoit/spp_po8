package task02;

public class Bicycle extends TransportVehicle {
    private double averageSpeed;

    public Bicycle(String name, int passengersCapacity, int cargoCapacity, double averageSpeed) {
        super(name, passengersCapacity, cargoCapacity);
        this.averageSpeed = averageSpeed;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / averageSpeed;
    }

    @Override
    public double calculateCost(double distance, double cargoWeight) {
        // Велосипед не требует дополнительных расходов на топливо или обслуживание
        return 0;
    }
}
