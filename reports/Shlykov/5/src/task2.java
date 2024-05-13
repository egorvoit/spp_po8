abstract class MusicalInstrument {
    String name;

    public MusicalInstrument(String name) {
        this.name = name;
    }

    abstract void play();
}

class Percussion extends MusicalInstrument {
    public Percussion(String name) {
        super(name);
    }

    @Override
    void play() {
        System.out.println("Играет ударный инструмент: " + name);
    }
}

class Stringed extends MusicalInstrument {
    public Stringed(String name) {
        super(name);
    }

    @Override
    void play() {
        System.out.println("Играет струнный инструмент: " + name);
    }
}

class Wind extends MusicalInstrument {
    public Wind(String name) {
        super(name);
    }

    @Override
    void play() {
        System.out.println("Играет духовой инструмент: " + name);
    }
}

class Orchestra {
    MusicalInstrument[] orchestra;

    public Orchestra(MusicalInstrument[] orchestra) {
        this.orchestra = orchestra;
    }

    void play() {
        for (MusicalInstrument instrument : orchestra) {
            instrument.play();
        }
    }
}

public class task2{
    public static void main(String[] args) {
        Percussion drum = new Percussion("Барабан");
        Stringed violin = new Stringed("Скрипка");
        Wind flute = new Wind("Флейта");

        MusicalInstrument[] instruments = {drum, violin, flute};

        Orchestra orchestra = new Orchestra(instruments);
        orchestra.play();
    }
}

