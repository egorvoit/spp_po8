public class SamsungCreator extends SmartphoneCreator{
    @Override
    public Smartphone createSmartphone() {
        return new Samsung("Galaxy S24 Ultra", "Qualcomm Snapdragon 8 Gen 3", 12, 256);
    }
}
