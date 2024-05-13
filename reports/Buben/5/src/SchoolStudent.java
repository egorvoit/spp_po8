
public class SchoolStudent extends Student {
    private int grade;

    public SchoolStudent(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void study() {
        System.out.println("School student " + getName() + " (" + getAge() + ") is studying");
    }

    public int getGrade() {
        return grade;
    }
}
