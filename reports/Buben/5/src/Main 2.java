
public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new SchoolStudent("John", 15, 10);
        students[1] = new CollegeStudent("Emma", 20, "Computer Science");
        students[2] = new SchoolStudent("Michael", 14, 9);

        System.out.println("Students study:");
        for (Student student : students) {
            student.study();
        }

        System.out.println("\nSchool Students:");
        for (Student student : students) {
            if (student instanceof SchoolStudent schoolStudent) {
                System.out.println("Name: " + schoolStudent.getName()
                        + ", Age: " + schoolStudent.getAge()
                        + ", Grade: " + schoolStudent.getGrade());
            }
        }

        System.out.println("\nCollege Students:");
        for (Student student : students) {
            if (student instanceof CollegeStudent collegeStudent) {
                System.out.println("Name: " + collegeStudent.getName()
                        + ", Age: " + collegeStudent.getAge()
                        + ", Major: " + collegeStudent.getMajor());
            }
        }
    }
}
