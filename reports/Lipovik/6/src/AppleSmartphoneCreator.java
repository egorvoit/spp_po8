public class AppleSmartphoneCreator extends SmartphoneCreator {
    @Override
    public Smartphone createSmartphone() {
        return new AppleSmartphone("iPhone 14", "iOS", 6.5, 2022);
    }
}
