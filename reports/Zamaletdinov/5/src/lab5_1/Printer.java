public class Printer implements PrintingDevice{

    protected String data;
    @Override
    public void printData() {
        System.out.println("Принтер печатает текст: \n" + data);
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }
}