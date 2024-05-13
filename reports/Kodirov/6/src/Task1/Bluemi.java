package Task1;

public class Bluemi extends Smartphone {
    public Bluemi(String model, int productionYear, int batteryCapacity, double screenSize) {
        super(model, productionYear, batteryCapacity, screenSize);
    }

    @Override
    public void printInfo() {
        System.out.println("Смартфон Bluemi модели " + super.model
                + "\nГод выпуска: " + super.productionYear
                + "\nЁмкость батерии: " + super.batteryCapacity + " мА·ч"
                + "\nРазмер экрана: " + super.screenSize + "\"");
    }
}
