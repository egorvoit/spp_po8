package Task3;

public class Main {
    public static void main(String[] args) {
        Faculty faculty = new Faculty("Факультет электронно-информационных систем");

        Course course = new Course("Основы алгоритмизации и программирования");
        faculty.addCourse(course);

        Teacher teacher = new Teacher("Щербаков Марк Егорович");
        teacher.announceRegistryForCourse(course);

        Student student1 = new Student("Степанова Алиса Константиновна");
        Student student2 = new Student("Жаров Артём Ильич");

        course.enrollStudent(student1);
        course.enrollStudent(student2);

        teacher.stopTeachingCourse(course);

        Archive.printAllRecords();
    }
}
