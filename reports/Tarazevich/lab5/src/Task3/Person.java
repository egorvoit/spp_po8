package Task3;

abstract public class Person {
    private String name;
    private final int id;
    private static int nextPersonId = 1;
    public Person(String name){
        this.name = name;
        id = nextPersonId++;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass())
            return false;
        return ((Person) obj).getId() == id;
    }
}
