import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1 {
    public static void main(String[] args) {
        String[] data = {"bat", "baby", "bonus", "cA", "ca", "co", "c.", "c0", "car", "combat", "count", "date", "disc"};

        Pattern p = Pattern.compile("c[a-z]*");

        for (String datum : data) {
            Matcher m = p.matcher(datum);
            if (m.matches())
                System.out.print(datum + ",");
        }
    }
}
