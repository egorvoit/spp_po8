class Navigator extends CrewMember {
    public Navigator(String name) {
        super(name);
    }

    @Override
    public String getInfo() {
        return "Штурман: " + this.name;
    }
}

