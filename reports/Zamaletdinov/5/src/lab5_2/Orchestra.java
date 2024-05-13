class Orchestra {
    private MusicalInstrument[] instruments;

    public Orchestra(int size) {
        instruments = new MusicalInstrument[size];
    }

    public void addInstrument(int index, MusicalInstrument instrument) {
        instruments[index] = instrument;
    }

    public void displayOrchestra() {
        System.out.println("Orchestra composition:");
        for (MusicalInstrument instrument : instruments) {
            if (instrument != null) {
                System.out.print("- ");
                instrument.play();
            }
        }
    }
}