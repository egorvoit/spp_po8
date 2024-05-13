package Task3;

import java.util.ArrayList;

public class Course {
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Course(String name) {
        this.name = name;
        students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void enrollStudent(Student student) {
        students.add(student);
        student.startStudying(this);
    }

    public void excludeStudent(Student student) {
        students.remove(student);
        student.stopStudying(this);
    }
}
