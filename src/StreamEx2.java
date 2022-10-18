import java.io.*;
import java.util.stream.*;

public class StreamEx2 {
    public static void main(String[] args) {
        File[] fileArr = { new File("Ex1.java"), new File("Ex1.bak"),
                new File("Ex2.java"), new File("Ex1"), new File("Ex1.txt")
        };

        Stream<File> fileStream = Stream.of(fileArr);

        // map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);

        fileStream = Stream.of(fileArr);

        fileStream.map(File::getName)
                .filter(a -> a.indexOf('.') != -1)
                .map(a -> a.substring(a.indexOf('.')+1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::print);

        System.out.println();
    }
}
