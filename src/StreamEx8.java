import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;

public class StreamEx8 {
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

        System.out.printf("1. 단순그룹화(반별로 그룹화)%n");
        Map<Integer, List<StudentEx4>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(StudentEx4::getBan));
        System.out.println("stuByBan = "+stuByBan);

        for(List<StudentEx4> ban : stuByBan.values()) {
            System.out.println("ban = "+ban);
            for(StudentEx4 s : ban) {
                System.out.println("s = "+s);
            }
        }

        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<StudentEx4.Level, List<StudentEx4>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if(s.getScore() > 200)
                        return StudentEx4.Level.HIGH;
                    else if(s.getScore() >= 100)
                        return StudentEx4.Level.MID;
                    else return StudentEx4.Level.LOW;
                }));
        TreeSet<StudentEx4.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for(StudentEx4.Level key: keySet) {
            System.out.println("["+key+"]");

            for(StudentEx4 s : stuByLevel.get(key))
                System.out.println(s);
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화 + 통계(성적별 학생수)%n");
        Map<StudentEx4.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s-> {
                    if(s.getScore() >= 200)
                        return StudentEx4.Level.HIGH;
                    else if(s.getScore() >= 100)
                        return StudentEx4.Level.MID;
                    else
                        return StudentEx4.Level.LOW;
                }, counting()));
        System.out.println("stuCntByLevel = "+stuCntByLevel);

        for(StudentEx4.Level key : stuCntByLevel.keySet())
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<StudentEx4>>> stuByHakAndBan =
                Stream.of(stuArr)
                        .collect(groupingBy(StudentEx4::getHak,
                                groupingBy(StudentEx4::getBan)
                        ));
        for(Map<Integer, List<StudentEx4>> hak : stuByHakAndBan.values()) {
            for(List<StudentEx4> ban : hak.values()) {
                System.out.println();
                for(StudentEx4 s : ban)
                    System.out.println(s);
            }
        }

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<StudentEx4.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s-> {
                            if(s.getScore() >= 200) return StudentEx4.Level.HIGH;
                            else if(s.getScore() >= 100) return StudentEx4.Level.MID;
                            else return StudentEx4.Level.LOW;
                        }, toSet())
                ));

        Set<String> keySet2 = stuByScoreGroup.keySet();

        for(String key : keySet2) {
            System.out.println("["+key+"]"+stuByScoreGroup.get(key));
        }
    }
}
