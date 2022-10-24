//import java.util.*;
//import java.util.stream.*;
//
//public class StreamEx3 {
//    public static void main(String[] args) {
//        StudentEx1[] stuArr = {
//                new StudentEx1("이자바",3,300),
//                new StudentEx1("김자바",1,200),
//                new StudentEx1("안자바",2,100),
//                new StudentEx1("박자바",2,150),
//                new StudentEx1("소자바",1,200),
//                new StudentEx1("나자바",3,290),
//                new StudentEx1("김자바",3,180)
//        };
//
//        Stream<StudentEx1> stuStream = Stream.of(stuArr);
//
//        stuStream.sorted(Comparator.comparing(StudentEx1::getBan)
//                .thenComparing(Comparator.naturalOrder()))
//                .forEach(System.out::println);
//
//        stuStream = Stream.of(stuArr);
//        IntStream stuScoreStream = stuStream.mapToInt(StudentEx1::getTotalScore);
//
//        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
//        System.out.println("count="+stat.getCount());
//        System.out.println("sum="+stat.getSum());
//        System.out.printf("average=%.2f%n", stat.getAverage());
//        System.out.println("min="+stat.getMin());
//        System.out.println("max="+stat.getMax());
//    }
//}
