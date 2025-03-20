q2-
solution-import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + "%)";
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 82.5));
        students.add(new Student("Bob", 65.3));
        students.add(new Student("Charlie", 90.4));
        students.add(new Student("David", 72.1));
        students.add(new Student("Eve", 88.6));

        students.stream()
                .filter(student -> student.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed())
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
