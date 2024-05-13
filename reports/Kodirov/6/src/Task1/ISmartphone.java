package Task1;

public class ISmartphone extends Smartphone {
    public ISmartphone(String model, int productionYear, int batteryCapacity, double screenSize) {
        super(model, productionYear, batteryCapacity, screenSize);
    }

    @Override
    public void printInfo() {
        System.out.println("Смартфон ISmartphone модели " + super.model
                + "\nГод выпуска: " + super.productionYear
                + "\nЁмкость батерии: " + super.batteryCapacity + " мА·ч"
                + "\nРазмер экрана: " + super.screenSize + "\"");
    }
}
