package Task1;

public class Main {
    public static void main(String[] args) {
        BluemiCreator bluemiCreator = new BluemiCreator();
        Smartphone bluemi = bluemiCreator.createSmartphone();
        bluemi.printInfo();

        System.out.println("");
        ISmartphoneCreator iSmartphoneCreator =  new ISmartphoneCreator();
        Smartphone iSmartphone = iSmartphoneCreator.createSmartphone();
        iSmartphone.printInfo();
    }
}