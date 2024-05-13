package task02;

public class Carriage extends TransportVehicle {
    private int horsePower;

    public Carriage(String name, int passengersCapacity, int cargoCapacity, int horsePower) {
        super(name, passengersCapacity, cargoCapacity);
        this.horsePower = horsePower;
    }

    @Override
    public double calculateTime(double distance) {
        return distance / (horsePower * 0.1);
    }

    @Override
    public double calculateCost(double distance, double cargoWeight) {
        return 0;
    }
}
