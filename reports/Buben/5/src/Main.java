
public class Main {
    public static void main(String[] args) {
        StudentOfFaculty student1 = new StudentOfFaculty("Student", 18, "Faculty");

        Abiturient[] abiturients = { student1 };
        Student[] students = { student1 };

        for (Abiturient abiturient : abiturients) {
            abiturient.applyForAdmission();
        }

        for (Student student : students) {
            student.study();
            student.takeExams();
        }
    }
}
