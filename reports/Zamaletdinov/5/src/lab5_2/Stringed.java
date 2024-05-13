class Stringed extends MusicalInstrument {
    private int numberOfStrings;
    public Stringed(String name, int numberOfStrings) {
        super(name);
        this.numberOfStrings = numberOfStrings;
    }
    @Override
    public void play() {
        System.out.println(name + " (number of strings: " + numberOfStrings + ") is being played.");
    }
}