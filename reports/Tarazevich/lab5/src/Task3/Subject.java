package Task3;

public enum Subject {
    MATHEMATICS("математика"), PHYSICS("физика"), HISTORY("история"),
    MODERN_PROGRAMMING_PLATFORMS("соременные платформы програмиирования");
    private final String name;
    Subject(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return name;
    }
}
