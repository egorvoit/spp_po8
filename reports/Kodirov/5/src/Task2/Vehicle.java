package Task2;

public abstract class Vehicle {
    protected String model;
    protected String sign;
    protected int maxSpeed;
    protected int passengersCapacity;
    protected int cargoCapacity;
    protected int currentSpeed;
    protected int currentPassengers;
    protected int currentCargo;
    protected double passengersCoefficient;
    protected double cargoCoefficient;

    public Vehicle(String model, String sign, int maxSpeed, int passengersCapacity, int cargoCapacity) {
        this.model = model;
        this.sign = sign;
        this.maxSpeed = maxSpeed;
        this.passengersCapacity = passengersCapacity;
        this.cargoCapacity = cargoCapacity;
        currentSpeed = 0;
        currentPassengers = 0;
        currentCargo = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void increaseSpeed(int increment) {
        currentSpeed += increment;
        if (currentSpeed > maxSpeed) {
            currentSpeed = maxSpeed;
        }
    }

    public void decreaseSpeed(int decrement) {
        currentSpeed -= decrement;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
    }

    public void setCurrentPassengers(int passengers) {
        if (passengers > passengersCapacity) {
            currentPassengers = passengersCapacity;
            System.out.println("Недостаточно мест, смогли сесть только " + currentPassengers + " пассажир(ов/а)");
        }
        currentPassengers = passengers;
        maxSpeed -= (int) (currentPassengers * passengersCoefficient);
    }

    public void setCurrentCargo(int cargo) {
        if (cargo > cargoCapacity) {
            currentCargo = cargoCapacity;
            System.out.println("Перевес, смогло уместиться только " + currentCargo +  "кг");
        }
        currentCargo = cargo;
        maxSpeed -= (int) (currentCargo * cargoCoefficient);
    }

    public abstract double countTransportationTime(int distance);
    public abstract double countTransportationCost(int distance);
}
