package Task3;

public class Student extends Person {
    public Student(String name) {
        super(name);
    }

    public void startStudying(Course course) {
        System.out.println("Студент " + super.name + " начал изучать курс " + course.getName());
    }

    public void stopStudying(Course course) {
        System.out.println("Студент " + super.name + " закончил изучать курс " + course.getName());
    }
}