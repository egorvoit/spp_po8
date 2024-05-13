package Task2;

import Task2.CargoCarriers.Car;
import Task2.CargoCarriers.Plane;
import Task2.CargoCarriers.Train;

import java.util.ArrayList;

public class CargoCarrierTest {
    public static void main(String[] args) {
        ArrayList<CargoCarrier> cargoCarriers = new ArrayList<>();
        cargoCarriers.add(new Car("KrasivayaMachina", 50, 5));
        cargoCarriers.add(new Train("BistriyPoesd", 100, 1));
        cargoCarriers.add(new Plane("MedleniySamolёt", 500, 10));

        City cityBrest = new City("Brest", new Position(500, 0));
        System.out.println(cityBrest.getName() + " " + cityBrest.getPosition() + ":");
        for (CargoCarrier cargoCarrier : cargoCarriers) {
            System.out.println("\t" + cargoCarrier.getName() + " " + cargoCarrier.getPosition() + ":");
            System.out.println("\t\t transportation time: " + cargoCarrier.getTransportationTime(cityBrest));
            System.out.println("\t\t transportation cost: " + cargoCarrier.getTransportationCost(cityBrest));
        }
    }
}
