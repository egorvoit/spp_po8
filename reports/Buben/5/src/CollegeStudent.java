public class CollegeStudent extends Student {
    private String major;

    public CollegeStudent(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void study() {
        System.out.println("College student " + getName() + " (" + getAge() + ") is studying");
    }

    public String getMajor() {
        return major;
    }
}
