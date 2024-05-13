package Task2;

public class Wagon extends Vehicle {
    private int horsesAmount;
    private int horsesSpeed;
    private final double baseFare = 5;

    public Wagon(String model, String sign, int passengersCapacity, int cargoCapacity, int horsesAmount, int horsesSpeed) {
        super(model, sign, horsesAmount * horsesSpeed, passengersCapacity, cargoCapacity);
        this.horsesAmount = horsesAmount;
        this.horsesSpeed = 10;
        super.passengersCoefficient = 1.0;
        super.cargoCoefficient = 0.1;
    }

    @Override
    public double countTransportationTime(int distance) {
        if (super.maxSpeed < 0) {
            System.out.println("Повозка " + super.model + " " + super.sign + " не может сдвинуться из-за перевеса");
            return -1;
        }
        if (super.currentSpeed == 0) {
            System.out.println("Повозка " + super.model + " " + super.sign + "стоит на месте");
            return -1;
        }
        return (double) distance / currentSpeed;
    }

    @Override
    public double countTransportationCost(int distance) {
        if (super.maxSpeed < 0) {
            System.out.println("Повозка " + super.model + " " + super.sign + " не может сдвинуться из-за перевеса");
            return -1;
        }
        if (currentSpeed == 0) {
            System.out.println("Повозка " + super.model + " " + super.sign + "стоит на месте");
            return -1;
        }
        return baseFare + super.currentPassengers * passengersCoefficient + super.currentCargo * cargoCoefficient;
    }
}
