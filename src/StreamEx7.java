import java.util.*;
import java.util.function.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

class StudentEx4 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int score;

    StudentEx4(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        this.score = score;
    }
    String getName() { return name; }
    boolean isMale() { return isMale; }
    int getHak() { return hak; }
    int getBan() { return ban; }
    int getScore() { return score; }

    public String toString() {
        return String.format("[%s, %s, %d학년 %d반, %3d점]",
                name, isMale ? "남":"여", hak, ban, score);
    }

    enum Level { HIGH, MID , LOW }
}

public class StreamEx7 {
    public static void main(String[] args) {
        StudentEx4[] stuArr = {
                new StudentEx4("나자바", true, 1, 1, 300),
                new StudentEx4("김지미", false, 1, 1, 250),
                new StudentEx4("김자바", true, 1, 1, 200),
                new StudentEx4("이지미", false, 1, 2, 150),
                new StudentEx4("남자바", true, 1, 2, 100),
                new StudentEx4("안지미", false, 1, 2, 50),
                new StudentEx4("황지미", false, 1, 3, 100),
                new StudentEx4("강지미", false, 1, 3, 150),
                new StudentEx4("이자바", true, 1, 3, 200),

                new StudentEx4("나자바", true, 2, 1, 300),
                new StudentEx4("김지미", false, 2, 1, 250),
                new StudentEx4("김자바", true, 2, 1, 200),
                new StudentEx4("이지미", false, 2, 2, 150),
                new StudentEx4("남자바", true, 2, 2, 100),
                new StudentEx4("안지미", false, 2, 2, 50),
                new StudentEx4("황지미", false, 2, 3, 100),
                new StudentEx4("강지미", false, 2, 3, 150),
                new StudentEx4("이자바", true, 2, 3, 200),
        };

        System.out.printf("1. 단순분할(성별로 분할)%n");
        Map<Boolean, List<StudentEx4>> stuBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentEx4::isMale));

        List<StudentEx4> maleStudent = stuBySex.get(true);
        List<StudentEx4> femaleStudent = stuBySex.get(false);

        for(StudentEx4 s : maleStudent)
            System.out.println(s);

        for(StudentEx4 s : femaleStudent)
            System.out.println(s);

        System.out.printf("%n2. 단순분할 + 통계(성별 학생수)%n");
        Map<Boolean, Long> stuNumBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentEx4::isMale,counting()));

        System.out.println("남학생 수:"+ stuNumBySex.get(true));
        System.out.println("여학생 수:"+ stuNumBySex.get(false));

        System.out.printf("%n3. 단순분할 + 통계(성별 1등)%n");
        Map<Boolean, Optional<StudentEx4>> topScoreBySex = Stream.of(stuArr)
                .collect(partitioningBy(StudentEx4::isMale,
                        maxBy(comparingInt(StudentEx4::getScore))));
        System.out.printf("남학생 1등 :" + topScoreBySex.get(true));
        System.out.printf("여학생 1등 :" + topScoreBySex.get(false));

        Map<Boolean, StudentEx4> topScoreBySex2 = Stream.of(stuArr)
                .collect(partitioningBy(StudentEx4::isMale,
                        collectingAndThen(
                                maxBy(comparingInt(StudentEx4::getScore)), Optional::get
                        )
                ));
        System.out.println("남학생 1등:"+ topScoreBySex2.get(true));
        System.out.println("여학생 1등:"+ topScoreBySex2.get(false));
        System.out.printf("%n4. 다중분할(성별 불합격자, 100점이하)%n");

        Map<Boolean, Map<Boolean, List<StudentEx4>>> failedStuBySex =
                Stream.of(stuArr).collect(partitioningBy(StudentEx4::isMale,
                        partitioningBy(s -> s.getScore() <= 100))
                );
        List<StudentEx4> failedMaleStu = failedStuBySex.get(true).get(true);
        List<StudentEx4> failedFemaleStu = failedStuBySex.get(false).get(true);

        for(StudentEx4 s : failedMaleStu)
            System.out.println(s);

        for(StudentEx4 s: failedFemaleStu)
            System.out.println(s);
    }
}
