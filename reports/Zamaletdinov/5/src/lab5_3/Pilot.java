class Pilot extends CrewMember {
    public Pilot(String name) {
        super(name);
    }

    @Override
    public String getInfo() {
        return "Пилот: " + this.name;
    }
}