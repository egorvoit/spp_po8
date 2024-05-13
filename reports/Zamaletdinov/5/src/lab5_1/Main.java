public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Printer laserPrinter = new LaserPrinter();

        printer.setData("Что вершит судьбу человечества?");
        laserPrinter.setData("Где моя медаль и грамота?");

        printer.printData();
        laserPrinter.printData();
    }
}