public class SamsungSmartphoneCreator extends SmartphoneCreator {
    @Override
    public Smartphone createSmartphone() {
        return new SamsungSmartphone("Galaxy Z flip 4", "Android", 7.5, 2023);
    }
}
