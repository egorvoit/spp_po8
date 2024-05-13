
public abstract class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void study();

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
