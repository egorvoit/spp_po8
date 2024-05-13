package Task3;

public class Teacher extends Person{
    public Teacher(String name) {
        super(name);
    }
    public int getMark(){
        return (int) (Math.random() * 100);
    }
}
