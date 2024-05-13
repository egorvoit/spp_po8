class Wind extends MusicalInstrument {
    private String material;

    public Wind(String name, String material) {
        super(name);
        this.material = material;
    }

    @Override
    public void play() {
        System.out.println(name + " (made of " + material + ") is being played.");
    }
}