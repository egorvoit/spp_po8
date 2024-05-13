import java.lang.String;
abstract class CrewMember {

    protected String name;

    public CrewMember(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getInfo();
}