public abstract class Smartphone {
    protected String model;
    protected String OS;
    protected double screenSize;
    protected int productionYear;

    public Smartphone(String _model, String _OS, double _screenSize, int _productionYear) {
        this.model = _model;
        this.OS = _OS;
        this.screenSize  =_screenSize;
        this.productionYear = _productionYear;
    }

    public abstract void printInfo();
}