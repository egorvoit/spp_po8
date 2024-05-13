class Percussion extends MusicalInstrument {
    private String drumType;

    public Percussion(String name, String drumType) {
        super(name);
        this.drumType = drumType;
    }

    @Override
    public void play() {
        System.out.println(name + " (type: " + drumType + ") is being played.");
    }
}