public class Main {
    public static void main(String[] args) {
        Orchestra orchestra = new Orchestra(5);
        
        orchestra.addInstrument(0, new Percussion("Drums", "Bass"));
        orchestra.addInstrument(1, new Stringed("Guitar", 6));
        orchestra.addInstrument(2, new Wind("Flute", "Wood"));
        orchestra.addInstrument(3, new Percussion("Cymbals", "Crash"));
        orchestra.addInstrument(4, new Stringed("Violin", 4));

        orchestra.displayOrchestra();
    }
}