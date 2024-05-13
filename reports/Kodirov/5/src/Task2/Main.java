package Task2;

public class Main {
    public static final double fuelCost = 2.36;

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("Porsche Caynne", "ABC123", 250, 4, 1500, 15.5);
        vehicles[1] = new Bicycle("Aeroad", "XYZ456", 50, 1, 30, 21);
        vehicles[2] = new Wagon("HorseCart", "DEF789", 3, 200, 3, 10);

        vehicles[0].setCurrentPassengers(3);
        vehicles[0].setCurrentCargo(500);
        vehicles[0].increaseSpeed(90);
        if (vehicles[0].countTransportationTime(100) >= 0) {
            System.out.printf("Автомобиль %s %s проедет 100 км за время %.2f ч, стоимость %.2f у.е.\n",
                    vehicles[0].getModel(),
                    vehicles[0].getSign(),
                    vehicles[0].countTransportationTime(100),
                    vehicles[0].countTransportationCost(100));
        }

        vehicles[1].setCurrentPassengers(0);
        vehicles[1].setCurrentCargo(30);
        vehicles[1].increaseSpeed(30);
        if (vehicles[1].countTransportationTime(50) >= 0) {
            System.out.printf("Велосипед %s %s проедет 100 км за время %.2f ч, стоимость %.2f у.е.\n",
                    vehicles[1].getModel(),
                    vehicles[1].getSign(),
                    vehicles[1].countTransportationTime(50),
                    vehicles[1].countTransportationCost(50));
        }

        vehicles[2].setCurrentPassengers(4);
        vehicles[2].setCurrentCargo(100);
        vehicles[2].increaseSpeed(20);
        if (vehicles[1].countTransportationTime(35) >= 0) {
            System.out.printf("Повозка %s %s проедет 100 км за время %.2f ч, стоимость %.2f у.е.\n",
                    vehicles[2].getModel(),
                    vehicles[2].getSign(),
                    vehicles[2].countTransportationTime(35),
                    vehicles[2].countTransportationCost(35));
        }
    }
}