import java.util.Arrays;
import java.util.stream.*;

public class StreamStudy {
    public static void main(String[] args) {
        String[] lineArr = {
                "Belive or not It is true",
                "Do or do not There is no try",
        };

        Stream<String> lineStream = Arrays.stream(lineArr);
        Stream<String> strStream = lineStream.flatMap(line -> Stream.of(line.split(" +")));
        strStream.forEach(System.out::println);
    }
}
