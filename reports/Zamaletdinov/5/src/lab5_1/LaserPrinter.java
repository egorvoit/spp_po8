public class LaserPrinter extends Printer{
    @Override
    public void printData() {
        System.out.println("Лазерный принтер печатает текст: \n" + data);
    }
}
