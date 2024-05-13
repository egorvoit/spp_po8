public class StudentOfFaculty extends Student {
    private String faculty;

    public StudentOfFaculty(String name, int age, String faculty) {
        super(name, age);
        this.faculty = faculty;
    }

    @Override
    public void applyForAdmission() {
        System.out.println("Applying for admission to " + faculty + " faculty");
    }

    @Override
    public void takeExams() {
        System.out.println("Taking exams for " + faculty + " faculty");
    }
}
