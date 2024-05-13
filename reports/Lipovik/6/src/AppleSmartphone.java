public class AppleSmartphone extends Smartphone {
    public AppleSmartphone(String model, String OS, double screenSize, int productionYear) {
        super(model, OS, screenSize, productionYear);
    }

    @Override
    public void printInfo() {
        System.out.println("Apple Smartphone"
                + "\nModel: " + super.model
                + "\nOS: " + super.OS
                + "\nScreen size: " + super.screenSize + "\""
                + "\nProduction year: " + super.productionYear);
    }
}
