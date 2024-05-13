public class XiaomiCreator extends SmartphoneCreator{
    @Override
    public Smartphone createSmartphone() {
        return new Xiaomi("POCO X4 GT", "MediaTek Dimensity 8100", 8, 256);
    }
}
