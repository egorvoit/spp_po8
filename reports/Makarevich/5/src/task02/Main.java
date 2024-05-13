package task02;

public class Main {
    public static void main(String[] args) {
        TransportVehicle[] vehicles = new TransportVehicle[3];

        vehicles[0] = new Car("Toyota Camry", 5, 500, 60, 5); // название, вместимость, грузоподъемность, скорость, стоимость за км
        vehicles[1] = new Bicycle("Mountain Bike", 1, 50, 20); // название, вместимость, грузоподъемность, средняя скорость
        vehicles[2] = new Carriage("Horse Carriage", 2, 200, 10); // название, вместимость, грузоподъемность, мощность лошади

        double distance = 100; // расстояние в км
        double cargoWeight = 50; // вес груза в кг

        for (TransportVehicle vehicle : vehicles) {
            double time = vehicle.calculateTime(distance);
            double cost = vehicle.calculateCost(distance, cargoWeight);

            System.out.println(vehicle.name);
            System.out.println("Time: " + time + " hours");
            System.out.println("Cost: $" + cost);
            System.out.println();
        }
    }
}

