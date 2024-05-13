public class task1 {
    public static void main(String[] args) {
        AppleSmartphoneCreator appleSmartphoneCreator = new AppleSmartphoneCreator();
        Smartphone appleSmartphone = appleSmartphoneCreator.createSmartphone();
        SamsungSmartphoneCreator iSmartphoneCreator =  new SamsungSmartphoneCreator();
        Smartphone iSmartphone = iSmartphoneCreator.createSmartphone();
        appleSmartphone.printInfo();
        System.out.println();
        iSmartphone.printInfo();
    }
}