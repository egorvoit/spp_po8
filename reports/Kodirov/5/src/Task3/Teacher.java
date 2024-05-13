package Task3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Teacher extends Person {
    private ArrayList<Course> courses;

    public Teacher(String name) {
        super(name);
        courses = new ArrayList<>();
    }

    public void announceRegistryForCourse(Course course) {
        courses.add(course);
        course.setTeacher(this);
        System.out.println("Прием на курс " + course.getName());
    }

    public void stopTeachingCourse(Course course) {
        System.out.println("Завершение курса " + course.getName());
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = course.getStudents();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("Поставьте оценку студенту " + student.getName() + " по предмету " + course.getName());
            Grade grade = new Grade(scanner.nextInt());
            Archive.addRecord(student, course, grade);
            iterator.remove();
            student.stopStudying(course);
        }
        courses.remove(course);
    }
}
