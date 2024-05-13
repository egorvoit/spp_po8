package task01;

public class Main {
    public static void main(String[] args) {
        // Создание объекта колледжа
        College college = new College();
        college.setName("Community College");
        college.setLocation("City Center");

        // Вывод информации о колледже
        System.out.println("College Name: " + college.getName());
        System.out.println("College Location: " + college.getLocation());

        // Создание объекта университета
        University university = new University();
        university.setName("State University");
        university.setLocation("Suburban Area");
        university.setAccreditation("Regional Accreditation");

        // Вывод информации о университете
        System.out.println("\nUniversity Name: " + university.getName());
        System.out.println("University Location: " + university.getLocation());
        System.out.println("University Accreditation: " + university.getAccreditation());
    }
}

