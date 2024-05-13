interface PrintingDevice {
    void print();
}

class Printer implements PrintingDevice {
    public void print() {
        System.out.println("Printing from printer...");
    }
}

class LaserPrinter extends Printer {
    @Override
    public void print() {
        System.out.println("Printing from laser printer...");
    }
}
public class task1{
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print();  

        LaserPrinter laserPrinter = new LaserPrinter();
        laserPrinter.print();
    }
}
