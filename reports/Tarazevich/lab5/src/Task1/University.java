package Task1;

public class University implements EducationalInstitution{
    private String address;
    private String name;
    public University(String name, String address){
        this.name = name;
        this.address = address;
    }
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void conductAdmissions() {
        System.out.println("Conduct admissions in university - " + name + " by the address " + address);
    }

    @Override
    public void conductGraduation() {
        System.out.println("Conduct graduation in university - " + name + " by the address " + address);
    }
}
