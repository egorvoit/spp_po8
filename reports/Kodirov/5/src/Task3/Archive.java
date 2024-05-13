package Task3;

import java.util.HashMap;

public class Archive {
    private static HashMap<Student, HashMap<Course, Grade>> records = new HashMap<>();

    public static void addRecord(Student student, Course course, Grade grade) {
        records.computeIfAbsent(student, k -> new HashMap<>()).put(course, grade);
    }

    public HashMap<Course, Grade> getStudentRecords(Student student) {
        return records.get(student);
    }

    public static void printAllRecords() {
        StringBuilder builder = new StringBuilder();
        for (HashMap.Entry<Student, HashMap<Course, Grade>> entry : records.entrySet()) {
            Student student = entry.getKey();
            HashMap<Course, Grade> studentRecords = entry.getValue();
            builder.append("Стундент: ").append(student.getName()).append("\n");
            for (HashMap.Entry<Course, Grade> recordEntry : studentRecords.entrySet()) {
                Course course = recordEntry.getKey();
                Grade grade = recordEntry.getValue();
                builder.append("\tКурс: ").append(course.getName()).append(", Оценка: ").append(grade.getValue()).append("\n");
            }
        }
        System.out.println(builder.toString());
    }
}