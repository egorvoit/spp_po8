abstract class MusicalInstrument {
    protected String name;
    public MusicalInstrument(String name) {
        this.name = name;
    }
    public abstract void play();
}