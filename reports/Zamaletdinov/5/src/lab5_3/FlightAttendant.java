class FlightAttendant extends CrewMember {
    public FlightAttendant(String name) {
        super(name);
    }

    @Override
    public String getInfo() {
        return "Стюардесса: " + this.name;
    }
}