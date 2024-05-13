package Task3;

/*
TODO:
    В задании 3 ЛР №4, где возможно, заменить объявления суперклассов объявлениями абстрактных
    классов или интерфейсов.

TODO:
    Построить модель программной системы с применением отношений (обобщения, агрегации,
    ассоциации, реализации) между классами. Задать атрибуты и методы классов. Реализовать
    (если необходимо) дополнительные классы. Продемонстрировать работу разработанной системы.

TODO:
    Система Вступительные экзамены:
    - Абитуриент регистрируется на Факультет, сдает Экзамены.
    - Преподаватель выставляет Оценку.
    - Система подсчитывает средний балл и определяет Абитуриентов, зачисленных в учебное заведение.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Faculty {
    private String name;
    private List<Subject> requiredExams = new ArrayList<>();
    private List<EnrolleeData> registeredEnrolles = new ArrayList<>();
    private List<EnrolleeData> evolvedEnrolles = new ArrayList<>();
    public static class EnrolleeData {
        private Enrollee enrollee;
        private Map<Subject, Integer> examMarks = new HashMap<>();

        EnrolleeData(Enrollee enrollee){
            this.enrollee = enrollee;
        }

        @Override
        public boolean equals(Object obj){
            if (obj == null)
                return false;
            if (obj.getClass() == getClass())
                return ((EnrolleeData) obj).getEnrollee().equals(enrollee);
            if (obj.getClass() == enrollee.getClass())
                return obj.equals(enrollee);
            return false;
        }
        public void setEnrollee(Enrollee enrollee) {
            this.enrollee = enrollee;
        }
        public Enrollee getEnrollee(){
            return enrollee;
        }
        public void setExamMark(Subject subject, int mark){
            if (!examMarks.containsKey(subject))
                examMarks.put(subject, mark);
        }
        public Map<Subject, Integer> getExamMarks(){
            return examMarks;
        }
        public int getExamScore(){
            int examScore = 0;
            for (int examMark : examMarks.values()){
                examScore += examMark;
            }
            return examScore / examMarks.size();
        }
        public boolean havePassedExam(Subject subject) {
            return examMarks.containsKey(subject);
        }

        @Override
        public String toString() {
            return "enrollee:" +
                    "\n\tid=" + enrollee.getId() +
                    "\n\tname='" + enrollee.getName() + "'" +
                    "\n\texams:" + examMarks.entrySet().stream()
                                          .map(el -> "\n\t\t" + el.getKey().getName() + " - " + el.getValue())
                                          .collect(Collectors.joining());
        }
    }
    Faculty(String name, List<Subject> requiredExams){
        this.name = name;
        this.requiredExams.addAll(requiredExams.stream().distinct().toList());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Faculty registerEnrollee(Enrollee enrollee){
        if (!registeredEnrolles.contains(enrollee)){
            EnrolleeData enrolleeData = new EnrolleeData(enrollee);
            registeredEnrolles.add(enrolleeData);
        }
        return this;
    }
    public Faculty registerEnrolles(List<Enrollee> enrolles){
        for (Enrollee enrollee : enrolles)
            registerEnrollee(enrollee);
        return this;
    }
    public Faculty conductExam(Subject subject, Teacher teacher){
        if (requiredExams.contains(subject))
            for (EnrolleeData enrolleeData : registeredEnrolles)
                if (!enrolleeData.havePassedExam(subject))
                    enrolleeData.setExamMark(subject, teacher.getMark());
        return this;
    }
    public void evolveFromEnrolleeToStudent(int passingScore){
        for (int i = 0; i < registeredEnrolles.size(); i++) {
            EnrolleeData enrolleeData = registeredEnrolles.get(i);
            if (enrolleeData.getExamMarks().size() == requiredExams.size()
                    && enrolleeData.getExamScore() >= passingScore){
                registeredEnrolles.remove(i--);
                evolvedEnrolles.add(enrolleeData);
            }
        }
    }
    public List<EnrolleeData> getEvolvedEnrolles(){
        return evolvedEnrolles;
    }
    public List<EnrolleeData> getRegisteredEnrolles() {
        return registeredEnrolles;
    }

    @Override
    public String toString() {
        return "Faculty:" +
                "\n\tname='" + name + "'" +
                "\n\trequiredExams:" + requiredExams.stream()
                                                  .map(el -> "\n\t\t" + el.getName())
                                                  .collect(Collectors.joining());
    }
}
