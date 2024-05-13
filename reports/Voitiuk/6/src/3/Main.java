interface PrinterStrategy {
    void execute(Printer printer);
}

class Print implements PrinterStrategy {
    public void execute(Printer printer) {
        if (printer.getPaperCount() > 0 && printer.getInkPercentage() > 0) {
            System.out.println("Печать документа...");
            printer.setPaperCount(printer.getPaperCount() - 1);
            printer.setInkPercentage(printer.getInkPercentage() - 0.1);
        } else {
            printer.setState(new FailureState(printer));
            printer.executeStrategy();
        }
    }
}

class LoadPaper implements PrinterStrategy {
    public void execute(Printer printer) {
        System.out.println("Загрузка бумаги...");
        printer.setPaperCount(100);
    }
}

class ExtractPaper implements PrinterStrategy {
    public void execute(Printer printer) {
        System.out.println("Извлечение зажатой бумаги...");
        printer.setJamProbability(0.01);
    }
}

class RefillCartridge implements PrinterStrategy {
    public void execute(Printer printer) {
        System.out.println("Заправка картриджа...");
        printer.setInkPercentage(100.0);
    }
}

interface PrinterState {
    void handleRequest(Printer printer);
}

class IdleState implements PrinterState {
    private Printer printer;

    public IdleState(Printer printer) {
        this.printer = printer;
    }

    public void handleRequest(Printer printer) {
        if (Math.random() < printer.getJamProbability()) {
            printer.setState(new JamState(printer));
        } else {
            printer.executeStrategy();
        }
    }
}

class JamState implements PrinterState {
    private Printer printer;

    public JamState(Printer printer) {
        this.printer = printer;
    }

    public void handleRequest(Printer printer) {
        System.out.println("Бумага зажата. Необходимо извлечь бумагу.");
        printer.setStrategy(new ExtractPaper());
        printer.executeStrategy();
        printer.setState(new IdleState(printer));
    }
}

class FailureState implements PrinterState {
    private Printer printer;

    public FailureState(Printer printer) {
        this.printer = printer;
    }

    public void handleRequest(Printer printer) {
        if (printer.getPaperCount() == 0) {
            System.out.println("Отсутствует бумага. Необходимо загрузить бумагу.");
            printer.setStrategy(new LoadPaper());
        } else if (printer.getInkPercentage() == 0) {
            System.out.println("Отсутствует краска. Необходимо заправить картридж.");
            printer.setStrategy(new RefillCartridge());
        }
        printer.executeStrategy();
        printer.setState(new IdleState(printer));
    }
}

class Printer {
    private PrinterStrategy strategy;
    private PrinterState state;
    private String model;
    private int paperCount;
    private double inkPercentage;
    private double jamProbability;

    public Printer(String model, int paperCount, double inkPercentage, double jamProbability) {
        this.model = model;
        this.paperCount = paperCount;
        this.inkPercentage = inkPercentage;
        this.jamProbability = jamProbability;
        this.strategy = new Print();
        this.state = new IdleState(this);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(int paperCount) {
        this.paperCount = paperCount;
    }

    public double getInkPercentage() {
        return inkPercentage;
    }

    public void setInkPercentage(double inkPercentage) {
        this.inkPercentage = inkPercentage;
    }

    public double getJamProbability() {
        return jamProbability;
    }

    public void setJamProbability(double jamProbability) {
        this.jamProbability = jamProbability;
    }

    public void setStrategy(PrinterStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute(this);
    }

    public void setState(PrinterState state) {
        this.state = state;
    }

    public void handleRequest() {
        state.handleRequest(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer("HP LaserJet", 100, 100.0, 0.8);

        printer.handleRequest();

        printer.setStrategy(new LoadPaper());
        printer.handleRequest();

        printer.setStrategy(new ExtractPaper());
        printer.handleRequest();

        printer.setStrategy(new RefillCartridge());
        printer.handleRequest();
    }
}
