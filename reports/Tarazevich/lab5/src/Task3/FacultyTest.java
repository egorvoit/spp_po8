package Task3;

import java.util.ArrayList;
import java.util.List;

public class FacultyTest {
    public static void main(String[] args) {
        String facultyName = "CreativnoyeImya";
        List<Subject> requiredExams = new ArrayList<>(List.of(Subject.HISTORY, Subject.MATHEMATICS));
        Faculty faculty = new Faculty(facultyName, requiredExams);

        faculty.registerEnrollee(new Enrollee("Petya"))
               .registerEnrollee(new Enrollee("Kirill"));

        Teacher teacher = new Teacher("Prepodavatel");

        faculty.conductExam(Subject.HISTORY, teacher)
               .conductExam(Subject.MATHEMATICS, teacher);

        System.out.println("All enrolles:");
        for (Faculty.EnrolleeData enrolleeData : faculty.getRegisteredEnrolles()) {
            System.out.println(enrolleeData);
        }

        faculty.evolveFromEnrolleeToStudent(70);

        System.out.println("\nEnrolled people:");
        for (Faculty.EnrolleeData enrolleeData : faculty.getEvolvedEnrolles()) {
            System.out.println(enrolleeData);
        }
    }
}
