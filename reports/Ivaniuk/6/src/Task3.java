package lab6;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Document document = new Document("+3752914880101.");
        Printer printer = new Printer("HP",100,80,1);
        printer.printDocument(document);

        System.out.println("\n");
        printer.setInkPercentage(0);
        printer.printDocument(document);
        printer.cartridgeRefilling(20);
        printer.printDocument(document);


        System.out.println("\n");
        printer.extractJammedPaper();
        printer.printDocument(document);

    }
}



// паттерн "Состояние"
interface PrinterState{
    void printDocument(Printer printer,Document document);
    void loadPaper(Printer printer,int count);
    void extractJammedPaper(Printer printer);
    void cartridgeRefilling(Printer printer,double percentage);
}

class PrinterWaitingState implements PrinterState{

    @Override
    public void printDocument(Printer printer, Document document) {
        System.out.println("Принтер готов к печати.");
        printer.changeState(new PrinterPrintingState());
        printer.printDocument(document);
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(count);
        System.out.println("В принтер добавлено " + count + " листов бумаги.");
    }

    @Override
    public void extractJammedPaper(Printer printer) {
        System.out.println("На данный момент нет зажатой бумаги.");
    }

    @Override
    public void cartridgeRefilling(Printer printer, double percentage) {
        printer.setInkPercentage(percentage);
        System.out.println("Катридж заправлен на " + percentage + " %.");
    }
}

class PrinterPrintingState implements PrinterState{

    @Override
    public void printDocument(Printer printer, Document document) {
        Random rnd = new Random();


        if(printer.getPaperCount() > 0 && printer.getInkPercentage() > 0){
            System.out.println("Печать документа, с содержимым: " + document.getContent());

            double possibilityOfJamming = rnd.nextDouble()*100;
            if(possibilityOfJamming <= printer.getPossibilityOfJamming()){
                System.out.println("Зажатие бумаги...");
                printer.changeState(new PrinterPaperJamState());
            }
            else{
                System.out.println("Документ успешно распечатан. Принтер в состоянии ожидания...");
                printer.changeState(new PrinterWaitingState());
            }

        }
        else{
            System.out.println("В принтере закончилась краска или бумага...");
            printer.changeState(new PrinterFailureState());
        }
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        System.out.println("Нельзя загрузить бумагу когда принтер печает...");
    }

    @Override
    public void extractJammedPaper(Printer printer) {
        System.out.println("Нельзя извелечь бумагу когда принтер печает...");
    }

    @Override
    public void cartridgeRefilling(Printer printer, double percentage) {
        System.out.println("Нельзя заправить катридж когда принтер печает...");
    }
}

class PrinterPaperJamState implements PrinterState{

    @Override
    public void printDocument(Printer printer, Document document) {
        System.out.println("В принтере есть зажатая бумага, извеликинете зажатую бумагу для продолжения печати...");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(count);
        System.out.println("В принтер добавлено " + count + " листов бумаги.");
        printer.changeState(new PrinterWaitingState());
    }

    @Override
    public void extractJammedPaper(Printer printer) {
        System.out.println("Извелечение зажатой бумаги...");
        printer.changeState(new PrinterWaitingState());
    }

    @Override
    public void cartridgeRefilling(Printer printer, double percentage) {
        System.out.println("Извлеките зажатую бумагу прежде чем заправить катридж краской...");
    }
}

class PrinterFailureState implements PrinterState{

    @Override
    public void printDocument(Printer printer, Document document) {
        System.out.println("В принетере закончилась краска или бумага...");
    }

    @Override
    public void loadPaper(Printer printer, int count) {
        printer.setPaperCount(count);
        System.out.println("В принтер добавлено " + count + " листов бумаги.");
        printer.changeState(new PrinterWaitingState());
    }

    @Override
    public void extractJammedPaper(Printer printer) {
        System.out.println("На данный момент в принтеере отсуствует зажатая бумага...");
    }

    @Override
    public void cartridgeRefilling(Printer printer, double percentage) {
        printer.setInkPercentage(percentage);
        System.out.println("Катридж заправлен на " + percentage + " %.");
        printer.changeState(new PrinterWaitingState());
    }
}

class Printer{

    private PrinterState currentState;
    private String model;
    private int paperCount;
    private double inkPercentage; //% краски в картридже
    private double possibilityOfJamming; //вероятность зажатия

    public Printer(String model, int paperCount, double inkPercentage, double possibilityOfJamming) {
        this.model = model;
        this.paperCount = paperCount;
        this.inkPercentage = inkPercentage;
        this.possibilityOfJamming = possibilityOfJamming;
        this.currentState = new PrinterWaitingState();
    }

    void printDocument(Document document){
        this.currentState.printDocument(this,document);
    }
    void loadPaper(int paperCount){
        this.currentState.loadPaper(this,paperCount);
    }

    void extractJammedPaper(){
        this.currentState.extractJammedPaper(this);
    }
    void cartridgeRefilling(double inkPercentage){
        this.currentState.cartridgeRefilling(this,inkPercentage);
    }

    void changeState(PrinterState state){
        this.currentState = state;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public void setInkPercentage(double inkPercentage) {
        this.inkPercentage = inkPercentage;
    }

    public void setPossibilityOfJamming(double possibilityOfJamming) {
        this.possibilityOfJamming = possibilityOfJamming;
    }

    public String getModel() {
        return model;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public double getInkPercentage() {
        return inkPercentage;
    }

    public double getPossibilityOfJamming() {
        return possibilityOfJamming;
    }
}
class Document{
    private String content;

    Document(String content){
        this.content = content;
    }

    String getContent(){
        return this.content;
    }

    void setContent(String content){
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Содержимое документа: \n" + this.content);
    }
}

