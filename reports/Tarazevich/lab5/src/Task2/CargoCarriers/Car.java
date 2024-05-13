package Task2.CargoCarriers;

import Task2.CargoCarrier;
import Task2.Position;
import Task2.Positionable;

public class Car extends CargoCarrier {
    private double speed;
    private double costPerKm;

    public Car(String name, double speed, double costPerKm) {
        super(name);
        this.speed = speed;
        this.costPerKm = costPerKm;
    }

    @Override
    public double getTransportationTime(Positionable positionable) {
        return Position.getDistanceBetweenPositions(positionable.getPosition(), this.getPosition()) / speed;
    }

    @Override
    public double getTransportationCost(Positionable positionable) {
        return Position.getDistanceBetweenPositions(positionable.getPosition(), this.getPosition()) * costPerKm;
    }
}
