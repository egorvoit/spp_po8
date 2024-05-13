package Task1;

public class ISmartphoneCreator extends SmartphoneCreator {
    @Override
    public Smartphone createSmartphone() {
        return new ISmartphone("2", 2009, 3200, 4.5);
    }
}
