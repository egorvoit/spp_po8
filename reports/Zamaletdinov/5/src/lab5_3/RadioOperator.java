class RadioOperator extends CrewMember {
    public RadioOperator(String name) {
        super(name);
    }

    @Override
    public String getInfo() {
        return "Радист: " + this.name;
    }
}