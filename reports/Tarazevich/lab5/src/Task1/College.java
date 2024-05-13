package Task1;

public class College implements EducationalInstitution {
    private String address;
    private String name;
    public College(String name, String address){
        this.name = name;
        this.address = address;
    }
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void conductAdmissions() {
        System.out.println("Conduct admissions in college - " + name + " by the address " + address);
    }

    @Override
    public void conductGraduation() {
        System.out.println("Conduct graduation in college - " + name + " by the address " + address);
    }
}
