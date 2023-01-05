import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormating {
    public static void main(String[] args) {
        String now = LocalDateTime.now().toString().replace("T", " ");
        System.out.println(now);
    }
}
