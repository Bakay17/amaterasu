package taskA;

import org.hibernate.Session;
import taskA.entity.Student;
import taskA.util.HibernateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1L, "Arlen", 4, 19, "man"),
                new Student(2L, "Marlen", 3, 20, "man"),
                new Student(3L, "Max", 3, 19, "man"),
                new Student(4L, "Alina", 5, 18, "woman"),
                new Student(5L, "Itachi", 5, 21, "man"),
                new Student(6L, "Christian", 3, 17, "man"),
                new Student(7L, "Esmahan", 5, 20, "woman"),
                new Student(8L, "Beyazet", 5, 19, "man"),
                new Student(9L, "Aidin", 5, 19, "man"),
                new Student(10L, "Cholpon", 4, 22, "woman")
        );

        for (Student student : students) {
            save(student);
        }

        getNamesList(students).forEach(System.out::println);
        System.out.println("==================");

        getNamesListByAge(students, 17).forEach(System.out::println);
        System.out.println("==================");

        printAnonymously(students);
        System.out.println("==================");

        getNamesFirstLetterList(students).forEach(System.out::println);
        System.out.println("==================");
    }

    public static <T>T save(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        return t;
    }

    public static List<String> getNamesList(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getNamesListByAge(List<Student> students, int minAge) {
        return students.stream()
                .filter(n -> n.getAge() > minAge)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void printAnonymously(List<Student> students) {
        students.forEach(student -> System.out.printf("ID: %s, Средняя оценка: %s\n", student.getId(), student.getAvGrade()));
    }

    public static List<String> getNamesFirstLetterList(List<Student> students) {
        return students.stream()
                .map(student -> student.getName() + " -> " + student.getName().charAt(0) + "" + student.getName().length())
                .collect(Collectors.toList());
    }
}
