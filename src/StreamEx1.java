import java.util.*;
import java.util.stream.*;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("김자바", 3, 180)
            );
        System.out.println(studentStream.getClass());

        studentStream.sorted(Comparator.comparing(Student::getBan)
                .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}

class StudentEx2 implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;
    StudentEx2(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
    }

    String getName() { return name; }
    int getBan() { return ban; }
    int getTotalScore() { return totalScore; }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}

//[김자바, 1, 200]
//[소자바, 1, 200]
//[박자바, 2, 150]
//[안자바, 2, 100]
//[이자바, 3, 300]
//[나자바, 3, 290]
//[김자바, 3, 180]

//[김자바, 1, 200]
//[소자바, 1, 200]
//[안자바, 2, 100]
//[박자바, 2, 150]
//[김자바, 3, 180]
//[나자바, 3, 290]
//[이자바, 3, 300]