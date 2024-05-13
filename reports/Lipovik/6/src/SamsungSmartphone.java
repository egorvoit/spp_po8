public class SamsungSmartphone extends Smartphone {
    public SamsungSmartphone(String model, String OS, double screenSize, int productionYear) {
        super(model, OS, screenSize, productionYear);
    }

    @Override
    public void printInfo() {
        System.out.println("Samsung smartphone"
                + "\nModel: " + super.model
                + "\nOS: " + super.OS
                + "\nScreen size: " + super.screenSize + "\""
                + "\nProduction year: " + super.productionYear);
    }
}