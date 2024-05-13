package Task1;

public abstract class Smartphone {
    protected String model;
    protected int productionYear;
    protected int batteryCapacity;
    protected double screenSize;

    public Smartphone(String model, int productionYear, int batteryCapacity, double screenSize) {
        this.model = model;
        this.productionYear = productionYear;
        this.batteryCapacity = batteryCapacity;
        this.screenSize  =screenSize;
    }

    public abstract void printInfo();
}
