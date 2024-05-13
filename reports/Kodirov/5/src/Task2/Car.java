package Task2;

public class Car extends Vehicle {
    private int mileage;
    private double fuelConsumption;

    public Car(String model, String sign, int maxSpeed, int passengersCapacity, int cargoCapacity, double fuelConsumption) {
        super(model, sign, maxSpeed, passengersCapacity, cargoCapacity);
        this.mileage = 0;
        this.fuelConsumption = fuelConsumption;
        super.passengersCoefficient = 0.07;
        super.cargoCoefficient = 0.001;
    }

    @Override
    public double countTransportationTime(int distance) {
        if (super.maxSpeed < 0) {
            System.out.println("Автомобиль " + super.model + " " + super.sign + " не может сдвинуться из-за перевеса");
            return -1;
        }
        if (currentSpeed == 0) {
            System.out.println("Автомобиль " + super.model + " " + super.sign + "стоит на месте");
            return -1;
        }
        mileage += distance;
        return (double) distance / currentSpeed;
    }

    @Override
    public double countTransportationCost(int distance) {
        if (super.maxSpeed < 0) {
            System.out.println("Автомобиль " + super.model + " " + super.sign + " не может сдвинуться из-за перевеса");
            return -1;
        }
        if (currentSpeed == 0) {
            System.out.println("Автомобиль " + super.model + " " + super.sign + "стоит на месте");
            return -1;
        }
        return (double) distance / currentSpeed * (fuelConsumption + super.currentPassengers * passengersCoefficient + super.currentCargo * cargoCoefficient) * Main.fuelCost;
    }
}
