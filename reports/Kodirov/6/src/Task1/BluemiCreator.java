package Task1;

public class BluemiCreator extends SmartphoneCreator {
    @Override
    public Smartphone createSmartphone() {
        return new Bluemi("12 Pro", 2022, 4500, 6.5);
    }
}
