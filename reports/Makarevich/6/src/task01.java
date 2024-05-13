import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TeacherEventDispatcher {
    Map<String, List<TeacherEventListener>> students = new HashMap<>();

    public TeacherEventDispatcher(String... events) {
        for (String event : events) {
            this.students.put(event, new ArrayList<>());
        }
    }

    public void subscribe (String event, TeacherEventListener student) {
        List<TeacherEventListener> subscribers = students.get(event);
        subscribers.add(student);
    }

    public void unsubscribe (String event, TeacherEventListener student) {
        List<TeacherEventListener> subscribers = students.get(event);
        subscribers.remove(student);
    }

    public void notify (String event, TeacherEventListener student) {
        List<TeacherEventListener> subscribers = students.get(event);
        for (TeacherEventListener subscriber : subscribers) {
            if(subscriber == student) {
                subscriber.update(event);
            }
        }
    }
}

class Teacher {
    public TeacherEventDispatcher events;

    public Teacher () {
        this.events = new TeacherEventDispatcher("Check lab work", "Conduct consultation",
                "Take exam", "Grade exam", "Conduct lecture");
    }

    void checkLabwork (Student student) {
        events.notify("Check lab work", student);
        System.out.println("Teacher interacted with " + student.getName());
    }

    void conductConsultation (Student student) {
        events.notify("Conduct consultation", student);
        System.out.println("Teacher interacted with " + student.getName());
    }

    void takeExam (Student student) {
        events.notify("Take exam", student);
        System.out.println("Teacher interacted with " + student.getName());
    }

    void gradeExam (Student student) {
        events.notify("Grade exam", student);
        System.out.println("Teacher interacted with " + student.getName());
    }

    void conductLecture (Student student) {
        events.notify("Conduct lecture", student);
        System.out.println("Teacher interacted with " + student.getName());
    }
}

interface TeacherEventListener {
    void update(String eventType);
}

class Student implements TeacherEventListener {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(String eventType) {
        System.out.println("Student " + name + " received notification: " + eventType);
    }
}

public class task01 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        Student student1 = new Student("Ivan");
        Student student2 = new Student("Maria");

        teacher.events.subscribe("Check lab work", student1);
        teacher.events.subscribe("Check lab work", student2);
        teacher.events.subscribe("Conduct consultation", student1);
        teacher.events.subscribe("Take exam", student2);
        teacher.events.subscribe("Grade exam", student1);
        teacher.events.subscribe("Conduct lecture", student2);

        teacher.checkLabwork(student1);
        teacher.conductConsultation(student1);
        teacher.takeExam(student2);
        teacher.gradeExam(student1);
        teacher.conductLecture(student2);
    }
}
