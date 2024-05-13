public abstract class Student implements Abiturient {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void study() {
        System.out.println(name + " (" + age + ") is studying...");
    }

    public abstract void takeExams();
}
