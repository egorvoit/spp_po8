public class Main {
    public static void main(String[] args) {
        XiaomiCreator xiaomiCreator = new XiaomiCreator();
        Smartphone xiaomi = xiaomiCreator.createSmartphone();
        xiaomi.printInfo();

        System.out.println("");

        SamsungCreator samsungCreator = new SamsungCreator();
        Smartphone samsung = samsungCreator.createSmartphone();
        samsung.printInfo();
    }
}