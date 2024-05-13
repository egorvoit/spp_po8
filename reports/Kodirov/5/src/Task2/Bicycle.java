package Task2;

public class Bicycle extends Vehicle {
    private int diskRadius;

    public Bicycle(String model, String sign, int maxSpeed, int passengersCapacity, int cargoCapacity, int diskRadius) {
        super(model, sign, maxSpeed, passengersCapacity, cargoCapacity);
        this.diskRadius = diskRadius;
        super.passengersCoefficient = 5;
        super.cargoCoefficient = 0.1;
    }

    @Override
    public double countTransportationTime(int distance) {
        if (super.maxSpeed < 0) {
            System.out.println("Велосипед " + super.model + " " + super.sign + " не может сдвинуться из-за перевеса");
            return -1;
        }
        if (currentSpeed == 0) {
            System.out.println("Велосипед " + super.model + " " + super.sign + "стоит на месте");
            return -1;
        }
        return (double) distance / (currentSpeed * (1.0 - (double) diskRadius / 100));
    }

    @Override
    public double countTransportationCost(int distance) {
        if (super.maxSpeed < 0) {
            System.out.println("Велосипед " + super.model + " " + super.sign + " не может сдвинуться из-за перевеса");
            return -1;
        }
        if (currentSpeed == 0) {
            System.out.println("Велосипед " + super.model + " " + super.sign + "стоит на месте");
            return -1;
        }
        return 0;
    }
}
